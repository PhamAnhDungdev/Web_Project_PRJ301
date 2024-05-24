
package ControllerAdmin;

import DAL.ProductsDAO;
import Model.Products;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class DeleteProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteProductServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteProductServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        int pid = 0;
        try {
            pid = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        ProductsDAO u = new ProductsDAO();
        Products p = u.getProductsById(pid);
        request.setAttribute("products", p);
        request.getRequestDispatcher("deleteproducts.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        int pid = 0;
        try {
            pid = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        ProductsDAO u = new ProductsDAO();
        u.deleteProducts(pid);
        String thongbao = "Đã xóa thành công!";
        request.setAttribute("thongbao", thongbao);
        request.getRequestDispatcher("productsmanager.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
