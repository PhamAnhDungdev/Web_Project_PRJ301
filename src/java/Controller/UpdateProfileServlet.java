
package Controller;

import DAL.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.regex.Pattern;

public class UpdateProfileServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateProfileServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProfileServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 
    public boolean checkInput(String input){
        return !Pattern.compile("[^a-zA-Z0-9\\s]").matcher(input).find();
    }
    public boolean checkPhone(String input) {
        return input.matches("[0-9]+");
    }
     public boolean checkPass(String input) {
        return input.contains(" ");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String fname = request.getParameter("first");
        String lname = request.getParameter("last");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        
        //
        HttpSession sess = request.getSession();
        User x = (User) sess.getAttribute("account");
        if(x != null){
            int role = 0;
            UserDAO u = new UserDAO();
            if (fname == null || lname == null || phone == null || email == null || address == null || username == null || password == null 
                 || checkInput(fname) || checkInput(lname)   || !checkPhone(phone) || phone.length()<10 || phone.length() > 10  || checkPass(password)) {
                 
                
                //out.print("Vui lòng điền đầy đủ thông tin và mật khẩu chính xác!!");
                request.setAttribute("thongbao", "Vui lòng điền đầy đủ thông tin và mật khẩu chính xác!!");
                request.getRequestDispatcher("profile.jsp").include(request, response);
            } else {
                User update = new User(fname, lname, phone, address, email, username, password, role);
                u.updateProfile(update, x.getId());
                out.print("Vui lòng đăng nhập lại sau khi update!");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }    
//            User afterupdate = u.getUserById(x.getId());
//            request.setAttribute("user", afterupdate);
//            request.getRequestDispatcher("profile.jsp").forward(request, response);

        }else{
            out.print("Vui lòng đăng nhập để update tải khoản!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        
               
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
