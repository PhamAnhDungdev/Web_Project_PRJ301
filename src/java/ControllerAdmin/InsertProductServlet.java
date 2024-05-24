
package ControllerAdmin;

import DAL.CategoriesDAO;
import DAL.ProductsDAO;
import Model.Products;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;


public class InsertProductServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertProductServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertProductServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String name = request.getParameter("name");
        String price_raw = request.getParameter("price");
        String title = request.getParameter("title");
        String image = request.getParameter("image");
        String describe = request.getParameter("describe");
        String cid_raw = request.getParameter("cid");
        
        int cid = 0;
        double price = 0;
        try {
            cid = Integer.parseInt(cid_raw);
            price = Double.parseDouble(price_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        String thongbao = null;
        if ( name == null || price_raw == null || title == null || describe == null ||  cid_raw == null || price <= 0
                ||  name.equals("") ||  price_raw.equals("") ||  title.equals("") ||  describe.equals("")) {
            thongbao = "Vui lòng kiểm tra và điền chính xác thông tin!";
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher("productsmanager.jsp").forward(request, response);
        }else{
            LocalDate localDate = LocalDate.now();
            Date registration = Date.valueOf(localDate);
            
            CategoriesDAO c = new CategoriesDAO();
            ProductsDAO u = new ProductsDAO();
            
            Products p = new Products( name, price, title, image, describe, registration,c.getCategoriesByID(cid) );
            u.insertProducts(p);
            thongbao = "Đã thêm sản phẩm thành công!";
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher("productsmanager.jsp").forward(request, response);
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
