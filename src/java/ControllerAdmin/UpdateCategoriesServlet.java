
package ControllerAdmin;

import DAL.CategoriesDAO;
import Model.Categories;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UpdateCategoriesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateCategoriesServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCategoriesServlet at " + request.getContextPath () + "</h1>");
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
        int id = 0;
        try {
            id = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        CategoriesDAO u = new CategoriesDAO();
        Categories c = u.getCategoriesByID(id);
        request.setAttribute("cate", c);
        request.getRequestDispatcher("updatecategories.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        int id = 0;
        try {
            id = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        String error = null;
        CategoriesDAO u = new CategoriesDAO();
        if(name == null || name.equals("")){
            error = "Vui lòng nhập chính xác tên thể loại!";
            request.setAttribute("thongbao", error);
            request.getRequestDispatcher("updatecategories.jsp").forward(request, response);
        }else{
            u.updateCategories(id, name);
            error = "Cập nhật thành công!";
            request.setAttribute("thongbao", error);
            request.getRequestDispatcher("categoriesmanager.jsp").forward(request, response);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
