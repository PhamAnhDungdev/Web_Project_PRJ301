
package Controller;

import DAL.ProductsDAO;
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

public class SortPfDESCServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SortPfDESCServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SortPfDESCServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String orderby = "DESC";
        int min = 0, max = 30000000;
        int cid = 0;
        ProductsDAO u = new ProductsDAO();
        HttpSession sess = request.getSession();
        User x = (User) sess.getAttribute("account");
        if(x != null){
            List<Products> list = u.orderByFavourite(x.getId(), cid, orderby);
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
