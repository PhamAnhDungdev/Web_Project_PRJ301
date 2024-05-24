
package Controller;

import DAL.ProductsFavouriteDAO;
import Model.Products;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;


public class ProductsFavouriteDeleteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductsFavouriteDeleteServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductsFavouriteDeleteServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String id_raw = request.getParameter("id");
        int productId = 0;
        try {
            productId = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        ProductsFavouriteDAO u = new ProductsFavouriteDAO();
        HttpSession sess = request.getSession();
        User x = (User) sess.getAttribute("account");
        if(x != null){
            u.deleteProductFavourite(x.getId(), productId);
            List<Products> list = u.getListByUserName(x.getId());
            request.setAttribute("list", list);
            request.getRequestDispatcher("favourite.jsp").forward(request, response);
        }else{
            out.print("Vui lòng đăng nhập để sắp xếp sản phẩm yêu thích!");
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
    }

}
