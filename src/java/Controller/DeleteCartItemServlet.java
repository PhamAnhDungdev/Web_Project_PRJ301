package Controller;

import DAL.CartDAO;
import DAL.CartItemDAO;
import Model.Cart;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteCartItemServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteCartItemServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteCartItemServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id_product = request.getParameter("pid");
        
        int pid = 0;
        try {
            pid = Integer.parseInt(id_product);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        
        CartItemDAO cartitem = new CartItemDAO();
        
        HttpSession sess = request.getSession(true);
        User x = (User) sess.getAttribute("account");
        
        if(x == null){
            out.print("Vui lòng đăng nhập lại để xóa giỏ hàng!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }else{
            CartDAO cart = new CartDAO();
            Cart k = cart.getCartByUid(x.getId());
            cartitem.deleteCartItemByPid(pid, k.getCartId());
            request.getRequestDispatcher("cart.jsp").forward(request, response);
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
    }// </editor-fold>

}
