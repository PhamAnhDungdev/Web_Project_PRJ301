/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

public class FilterAndSortServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FilterAndSortServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilterAndSortServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String interval = request.getParameter("price-option");
        String sort = request.getParameter("order");
        String cid_raw = request.getParameter("cid");
        int min = 0, max = 0;

        if (interval == null) {
            min = 0;
            max = 25000000;
        } else {
            if (interval.equals("1")) {
                min = 0;
                max = 2000000;
            } else if (interval.equals("2")) {
                min = 2000000;
                max = 4000000;
            } else if (interval.equals("3")) {
                min = 4000000;
                max = 8000000;
            } else if (interval.equals("4")) {
                min = 8000000;
                max = 10000000;
            } else if (interval.equals("5")) {
                min = 10000000;
                max = 15000000;
            } else {
                min = 15000000;
                max = 25000000;
            }
        }

        int cid = 0;
        try {
            cid = Integer.parseInt(cid_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        String orderby = null;
        if (sort.equals("1")) {
            orderby = "ASC";
        } else {
            orderby = "DESC";
        }

        ProductsDAO u = new ProductsDAO();
        List<Products> list = u.sortByIntervalAndOrder(min, max, orderby, cid);
        request.setAttribute("list", list);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
