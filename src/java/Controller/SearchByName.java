package Controller;

import DAL.ProductsDAO;
import Model.Products;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;


public class SearchByName extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchByName</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchByName at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String productName = request.getParameter("pname");
        ProductsDAO u = new ProductsDAO();
        List<Products> getByName = u.getProductByName(productName);
        if(getByName != null){
            request.setAttribute("list", getByName);
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        }else{
            //out.print("Không tìm thấy sản phẩm!!");
            request.setAttribute("thongbao", "Không tìm thấy sản phẩm!");
            request.getRequestDispatcher("shop.jsp").forward(request, response);
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
