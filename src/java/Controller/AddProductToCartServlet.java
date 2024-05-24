package Controller;

import DAL.CartDAO;
import DAL.CartItemDAO;
import Model.Cart;
import Model.CartItem;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.connector.Request;

public class AddProductToCartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddProductToCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProductToCartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String id_praw = request.getParameter("id");
        String quantity_raw = request.getParameter("quantity");
        int pid = Integer.parseInt(id_praw);

        int userId = 0, quantity = 0;
        if (quantity_raw == null) {
            quantity = 1;
        } else {
            try {
                quantity = Integer.parseInt(quantity_raw);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }
        try {
            quantity = Integer.parseInt(quantity_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        CartDAO cd = new CartDAO();
        CartItemDAO cid = new CartItemDAO();

        HttpSession sess = request.getSession(true);
        User x = (User) sess.getAttribute("account");

        if (x == null) {//kiểm tra user đã đăng nhập hay chưa
            out.print("Vui lòng đăng nhập để thêm sản phẩm vào giỏ hàng!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            //mỗi 1 user chỉ 1 cart//mỗi 1 cart có n cartitem//mỗi cartitem sẽ có 1 product
            userId = x.getId();
            // insert vào cart// nếu đã có 1 cart tương ứng với user id, sẽ không insert nữa   
            Cart c = cd.getCartByUid(userId);//cd.getCartByUid(userId) == null
            if (c == null) {
                cd.insertCart(userId);
            }  //nếu khác null, thì sẽ chỉ insert vào cartitem
            CartItem cartitem = cid.getCartItemByPUid(pid, userId);
            if (cartitem == null) { //nếu chưa có sản phẩm này trong cartitem thì thêm mới vào
                //Cart c = cd.getCartByUid(userId); //lấy được cartID;
                cid.insertCartItem(c.getCartId(), pid, quantity);//insert xuống cartitem
            } else {
                int nquantity = quantity + cartitem.getQuantity();
//                int nquantity =0 ;
//                int oquantity = cartitem.getQuantity();
//                if(oquantity <= 3){
//                    nquantity = 1 + cartitem.getQuantity();
//                    cid.updateQuantityCartItem(cartitem.getCartItemId(), nquantity);
//                }else if(oquantity <= 4){
//                    nquantity = 2 +cartitem.getQuantity();
//                    cid.updateQuantityCartItem(cartitem.getCartItemId(), nquantity);
//                }else if(oquantity > 4){
//                    nquantity = 3 + cartitem.getQuantity();
//                    cid.updateQuantityCartItem(cartitem.getCartItemId(), nquantity);
//                }
                cid.updateQuantityCartItem(cartitem.getCartItemId(), nquantity);
            }
            request.getRequestDispatcher("cart.jsp").forward(request, response);
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
    }

}
