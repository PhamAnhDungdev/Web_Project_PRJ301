
package Controller;

import DAL.ProductsFavouriteDAO;
import Model.Products;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


public class ListProductsFavourServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListProductsFavourServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListProductsFavourServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String id_user = request.getParameter("id");
        int userId = 0;
        try {
            userId = Integer.parseInt(id_user);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        
        ProductsFavouriteDAO u = new ProductsFavouriteDAO();
        List<Products> list = u.getListByUserName(userId);
        request.setAttribute("list", list);
        request.getRequestDispatcher("favourite.jsp").forward(request, response);
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
