
package ControllerAdmin;

import DAL.CategoriesDAO;
import DAL.ProductsDAO;
import Model.Categories;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DeleteCategoriesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteCategoriesServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteCategoriesServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        CategoriesDAO u = new CategoriesDAO();
        Categories c = u.getCategoriesByID(id);
        request.setAttribute("cate", c);
        request.getRequestDispatcher("deletecategories.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String cid_raw = request.getParameter("id");
        int cid = 0;
        try {
            cid = Integer.parseInt(cid_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        CategoriesDAO u = new CategoriesDAO();
        ProductsDAO p = new ProductsDAO();
        
        u.deleteCategories(cid);
        p.deleteProductsByCId(cid);
        String error = "Đã xóa thành công!";
        request.setAttribute("thongbao", error);
        request.getRequestDispatcher("categoriesmanager.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
