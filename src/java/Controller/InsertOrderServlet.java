package Controller;

import DAL.CartDAO;
import DAL.CartItemDAO;
import DAL.OrderDetailDAO;
import DAL.OrdersDAO;
import DAL.ProductsDAO;
import Model.Cart;
import Model.CartItem;
import Model.OrderDetails;
import Model.Orders;
import Model.Products;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class InsertOrderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertOrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertOrderServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //get thông tin từ trang checkout
        String firstname = request.getParameter("first");
        String lastname = request.getParameter("last");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String country = request.getParameter("country");

        //lấy user từ session
        HttpSession sess = request.getSession();
        User x = (User) sess.getAttribute("account");

        //lấy thông tin order từ cart, cartitem
        CartDAO c = new CartDAO();
        CartItemDAO ci = new CartItemDAO();
        ProductsDAO p = new ProductsDAO();//lấy list products trong cart
        //get cartby userID để lấy cartID cho cartitem
        if (x != null) {
            Cart cart = c.getCartByUid(x.getId());

            //Lấy list cartitem và list products tính total amount
            List<CartItem> listci = null;
            List<Products> listp = p.getListByUserId(x.getId());
            double totalamount = 0;
            if (cart != null) {
                listci = ci.getListCartByCid(cart.getCartId());
                for (int i = 0; i < listci.size(); i++) {
                    totalamount += listci.get(i).getQuantity() * listp.get(i).getPrice();
                }
                totalamount += 200000;
            }
            //tính tổng total amount
            //insert xuống order; 
            OrdersDAO o = new OrdersDAO();
            LocalDate localDate = LocalDate.now();
            Date orderdate = Date.valueOf(localDate);
            Orders or = new Orders(x.getId(), firstname, lastname, phone, email, address, country, orderdate, totalamount);
            o.inserOrders(or);
            //insert xong bảng order

            //insert bảng orderdetal
            //id, orderid, productID, quantity, subtotal
            int orderIdLast = o.getOrderIDByUserID(x.getId());
            OrderDetailDAO odd = new OrderDetailDAO();
            for (int i = 0; i < listp.size(); i++) {
                OrderDetails ord = new OrderDetails(orderIdLast, listp.get(i).getId(), listci.get(i).getQuantity(), listp.get(i).getPrice());
                odd.inserOrderDetail(ord);
            }

            //sau khi insert order(đã đặt hàng) thì xóa các sản phẩm đã đặt trong giỏ hàng
            Cart dc = c.getCartByUid(x.getId());//get cartId ứng với userid 

//            List<CartItem> listcart = ci.getListCartByCid(dc.getCartId()); //get list cart item tương ứng với cartID(của userID)
//            for (int i = 0; i < listcart.size(); i++) { //lọc qua list
//                
//            }
            ci.deleteCartItemDaoByCid(dc.getCartId());

           // ci.getListCartByCid(dc.getCartId());

            c.deleteCartByUid(x.getId());

            //quay về trang chủ
            String thongbao = "Qúy khách đã đặt hàng thành công!";
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        } else {
            out.print("Vui lòng đăng nhập để thực hiện đặt hàng!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
