
package Controller;

import DAL.CartDAO;
import DAL.CartItemDAO;
import DAL.ProductsDAO;
import Model.Cart;
import Model.Products;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class DisplayCartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayCartServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisplayCartServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ProductsDAO u = new ProductsDAO();
        
        List<Products> list = new ArrayList<>();
        //get account user
        HttpSession sess = request.getSession(true);
        User x = (User) sess.getAttribute("account");
        CartDAO cd = new CartDAO();
        if(x == null){
            out.print("Vui lòng đăng nhập để xem giỏ hàng!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }else{
            list = u.getListByUserId(x.getId());//get all list sản phẩm giỏ hàng của user này
            request.setAttribute("listp", list);
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
