
package Controller;

import DAL.ProductsFavouriteDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class ProductsInsertCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductsInsertCart</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductsInsertCart at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //Lỗi
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//
//        String id_raw = request.getParameter("id");
//        int productId = 0;
//        
//        try {
//            productId = Integer.parseInt(id_raw);
//        } catch (NumberFormatException e) {
//            System.out.println(e);
//        }
//
//        HttpSession sess = request.getSession();
//        User x = (User) sess.getAttribute("account");
//
//        if (sess.getAttribute("account") == null) {
//            out.print("Vui lòng đăng nhập để thực hiện thao tác thêm sản phẩm yêu thích!");
//            request.getRequestDispatcher("login.jsp").include(request, response);
//        } else {
//            int userId = x.getId();
//            ProductsFavouriteDAO u = new ProductsFavouriteDAO();
//            u.insertProductFavourite(userId, productId);
//            request.getRequestDispatcher("shop.jsp").forward(request, response);
//        }
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
