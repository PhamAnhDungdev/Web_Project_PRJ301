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

public class UpdateProductsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProductsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProductsServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pid_raw = request.getParameter("id");
        int pid = 0;
        try {
            pid = Integer.parseInt(pid_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        ProductsDAO u = new ProductsDAO();
        Products p = u.getProductsById(pid);
        request.setAttribute("products", p);
        request.getRequestDispatcher("updateproducts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String price_raw = request.getParameter("price");
        String title = request.getParameter("title");
        String describe = request.getParameter("describe");
        String image = request.getParameter("image");
        String cate = request.getParameter("cate");

        int cateid = 0;
        int id = 0;
        double price = 0;
        try {
            cateid = Integer.parseInt(cate);
            id = Integer.parseInt(id_raw);
            price = Double.parseDouble(price_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        ProductsDAO u = new ProductsDAO();
        String thongbao = null;
        if (id_raw == null || name == null || price_raw == null || title == null || describe == null || image == null || cate == null || price <= 0
                ||  name.equals("") ||  price_raw.equals("") ||  title.equals("") ||  describe.equals("")) {
            thongbao = "Vui lòng kiểm tra và điền chính xác thông tin!";
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher("productsmanager.jsp").forward(request, response);
        } else {
            LocalDate localDate = LocalDate.now();
            Date registration = Date.valueOf(localDate);
            CategoriesDAO c = new CategoriesDAO();
            Products p = new Products(id, name, price, title, image, describe, registration,c.getCategoriesByID(cateid) );
            u.updateProduct(p);
            thongbao = "Cập nhật thành công!";
            request.setAttribute("thongbao", thongbao);
            request.getRequestDispatcher("productsmanager.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
