
package Controller;

import DAL.ContactDAO;
import Model.Contact;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class InsertContactServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertContactServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertContactServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String title = request.getParameter("title");
        String message = request.getParameter("message");
        
        ContactDAO cd = new ContactDAO();
        Contact c  = new Contact(name, title, email, message);
        if(name != null && email != null && title != null && message != null && !name.equals("") && !email.equals("")
                && !title.equals("") && !message.equals("")){
            cd.insertContact(c);
            request.getRequestDispatcher("contact.jsp").forward(request, response);
        }else{
            String error = "Vui lòng điền đầy đủ thông tin và lời nhắn!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("contact.jsp").forward(request, response);
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
