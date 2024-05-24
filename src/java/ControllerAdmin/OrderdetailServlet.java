
package ControllerAdmin;

import DAL.OrderDetailDAO;
import Model.OrderDetails;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class OrderdetailServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderdetailServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderdetailServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String oid_raw = request.getParameter("id");
        int oid = 0;
        try {
            oid = Integer.parseInt(oid_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        OrderDetailDAO u = new OrderDetailDAO();
        List<OrderDetails> list = u.getOrderDetailById(oid);
        request.setAttribute("list", list);
        request.getRequestDispatcher("showorderdetail.jsp").forward(request, response);
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
