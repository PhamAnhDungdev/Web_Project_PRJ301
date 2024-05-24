
package ControllerAdmin;

import DAL.CategoriesDAO;
import Model.Categories;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


public class AddCategoriesServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCategoriesServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCategoriesServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String error = null;
        CategoriesDAO c = new CategoriesDAO();
        if(name == null || name.equals("")) {
            error = "Vui lòng nhập chính xác tên thể loại!";
            request.setAttribute("thongbao", error);
            request.getRequestDispatcher("categoriesmanager.jsp").forward(request, response);
        }else{
            c.addCategories(name);
            List<Categories> list = c.getListCategories();
            error = "Thêm mới thể loại sản phẩm thành công!";
            request.setAttribute("thongbao", error);
            request.setAttribute("list", list);
            request.getRequestDispatcher("categoriesmanager.jsp").forward(request, response);
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
