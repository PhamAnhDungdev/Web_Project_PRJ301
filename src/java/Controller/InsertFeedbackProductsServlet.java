package Controller;

import DAL.FeedbackDAO;
import DAL.ProductsDAO;
import Model.Feedback;
import Model.Products;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class InsertFeedbackProductsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertFeedbackProductsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertFeedbackProductsServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //get data từ form
        String pid_raw = request.getParameter("pid");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String review = request.getParameter("review");

        int pid = 0;
        try {
            pid = Integer.parseInt(pid_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        LocalDate localDate = LocalDate.now();
        Date DateReview = Date.valueOf(localDate);
        FeedbackDAO u = new FeedbackDAO();
        ProductsDAO k = new ProductsDAO();
        Feedback f = null;
        String thongbao = null;
        Products pro = k.getProductsById(pid);
        List<Feedback> list = null;
        //List<Feedback> list = u.getFeedbackByPid(pid);
        
        if (pid_raw != null && name != null && email != null && review != null && 
                !name.equals("") && !email.equals("") && !review.equals("")) {
            f = new Feedback(pid, name, email, DateReview, review);
            u.insertFeedback(f);
            thongbao = "Đánh giá sản phẩm của bạn đã được gửi!";
        } else {
            thongbao = "Vui lòng điền đầy đủ thông tin trên mẫu!";
        }
        request.setAttribute("listfb", list);
        request.setAttribute("productdetail", pro);
        request.setAttribute("thongbao", thongbao);
        request.getRequestDispatcher("detail.jsp").forward(request, response);
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
