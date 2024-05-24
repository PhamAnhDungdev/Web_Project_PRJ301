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

public class FilterIntervalServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FilterIntervalServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterIntervalServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String min_raw = request.getParameter("min");
        String max_raw = request.getParameter("max");
        String sort = request.getParameter("order");
        String cid_raw = request.getParameter("cid");
        double min = 0, max = 0;
        if (min_raw == null || max_raw == null) {
            min = 0;
            max = 25000000;
        } else {
            try {
                min = Double.parseDouble(min_raw);
                max = Double.parseDouble(max_raw);
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        }

        String orderby = null;
        if (sort.equals("1")) {
            orderby = "ASC";
        } else {
            orderby = "DESC";
        }
        int cid = 0;
        try {
            cid = Integer.parseInt(cid_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        ProductsDAO u = new ProductsDAO();
        List<Products> list = u.sortByIntervalAndOrder(min, max, orderby, cid);
        request.setAttribute("list", list);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
