package Controller;

import DAL.UserDAO;
import Model.User;
import java.time.LocalDateTime;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import java.util.Date;
import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

//        String firstname = request.getParameter("first");
//        String lastname = request.getParameter("last");
//        String phone = request.getParameter("phone");
//        String email = request.getParameter("email");
//        String address = request.getParameter("address");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String repass = request.getParameter("repass");
//
//        UserDAO u = new UserDAO();
//        User getUser = u.getUserByUsername(username);
//        if (firstname == null || lastname == null
//                || phone == null || email == null || address == null
//                || username == null || password == null || repass == null) {
//            out.print("Vui lòng điền đầy đủ thông tin và mật khẩu chính xác!!");
//            request.getRequestDispatcher("register.jsp").include(request, response);
//        } else if (!password.equals(repass)) {
//            out.print("Vui lòng điền chính xác 2 lần của mật khẩu!");
//            request.getRequestDispatcher("register.jsp").include(request, response);
//        } else if (getUser != null) {
//            out.print("Tên tài khoản đã tồn tại, vui lòng chọn 1 tên khác!");
//            request.getRequestDispatcher("register.jsp").include(request, response);
//        } else {
//            int role = 0;
//            LocalDate localDate = LocalDate.now();
//            Date registration = Date.valueOf(localDate); 
//            User user = new User(firstname, lastname, phone, address, email, username, password, role, registration);
//            u.insertUser(user);
//            out.print("Đăng kí thành công. Vui lòng đăng nhập để tiếp tục mua hàng!");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }
    }
    public boolean checkInput(String input){
        return !Pattern.compile("[^a-zA-Z0-9\\s]").matcher(input).find();
    }
    public boolean checkPhone(String input) {
        return input.matches("[0-9]+");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstname = request.getParameter("first");
        String lastname = request.getParameter("last");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repass = request.getParameter("repass");

        UserDAO u = new UserDAO();
        User getUser = u.getUserByUsername(username);
        if (firstname == null || lastname == null
                || phone == null || email == null || address == null
                || username == null || password == null || repass == null || checkInput(firstname) || checkInput(lastname) || checkPhone(phone)
                || phone.length()<10 || phone.length() > 10 ) {
            out.print("Vui lòng điền đầy đủ thông tin và mật khẩu chính xác!!");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!password.equals(repass)) {
            out.print("Vui lòng điền chính xác 2 lần của mật khẩu!");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (getUser != null) {
            out.print("Tên tài khoản đã tồn tại, vui lòng chọn 1 tên khác!");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            int role = 0; 
            LocalDate localDate = LocalDate.now();
            Date registration = Date.valueOf(localDate); 
            User user = new User(firstname, lastname, phone, address, email, username, password, role, registration);
            u.insertUser(user);
            out.print("Đăng kí thành công. Vui lòng đăng nhập để tiếp tục mua hàng!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
//java.sql.Date registration = new java.sql.Date(System.currentTimeMillis());
//java.sql.Date Registration = new java.sql.Date(registration.getTime());
//LocalDateTime localDateTime = LocalDateTime.now(); // hoặc bất kỳ LocalDateTime nào khác