package Controller;

import DAL.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        
//        //Get request param
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        
//        //get data in database
//        UserDAO u = new UserDAO();
//        User loguser = u.getUserByUserPass(username, password);
//        HttpSession session = request.getSession();
//        
//        if(loguser != null && loguser.getRole() == 0){//có tồn tại và là user
//            session.setAttribute("account", loguser);
//            request.getRequestDispatcher("home.jsp").forward(request, response);
//        }else if(loguser != null && loguser.getRole() == 1){//không tồn tại
//            session.setAttribute("admin", loguser); //có tồn tại và là admin
//            request.getRequestDispatcher("admin.jsp").forward(request, response);
//        }else{ //không tồn tại
//            out.print("Tài khoản hoặc mật khẩu không đúng. Vui lòng điền lại!");
//            request.getRequestDispatcher("login.jsp").include(request, response);
//        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //Get request param
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        //get data in database
        UserDAO u = new UserDAO();
        User loguser = u.getUserByUserPass(username, password);
        HttpSession session = request.getSession();
        Cookie c_user = new Cookie("cuser", username);
        Cookie c_pass = new Cookie("cpass", password);
        Cookie c_rem = new Cookie("crem", remember);
        if(loguser != null && loguser.getRole() == 0){//có tồn tại và là user
            session.setAttribute("account", loguser);
            if(remember != null){
                c_user.setMaxAge(10 * 24 * 3600);
                c_pass.setMaxAge(10 * 24 * 3600);
                c_rem.setMaxAge(10 * 24 * 3600);
            }else{
                c_user.setMaxAge(0);
                c_pass.setMaxAge(0);
                c_rem.setMaxAge(0);
            }
            response.addCookie(c_pass);//add cookie vào browser
            response.addCookie(c_user);
            response.addCookie(c_rem);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else if(loguser != null && loguser.getRole() == 1){//không tồn tại
            session.setAttribute("admin", loguser); //có tồn tại và là admin
            if(remember != null){
                c_user.setMaxAge(10 * 24 * 3600);
                c_pass.setMaxAge(10 * 24 * 3600);
                c_rem.setMaxAge(10 * 24 * 3600);
               
            }else{
                c_user.setMaxAge(0);
                c_pass.setMaxAge(0);
                c_rem.setMaxAge(0);
            }
            response.addCookie(c_pass);//add cookie vào browser
            response.addCookie(c_user);
            response.addCookie(c_rem);
            request.getRequestDispatcher("adminhome.jsp").forward(request, response);
        }else{ //không tồn tại
            out.print("Tài khoản hoặc mật khẩu không đúng. Vui lòng điền lại!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        //phần nháp của GET
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
