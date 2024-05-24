package Controller;

import DAL.ProductsDAO;
import DAL.ProductsFavouriteDAO;
import Model.ProductFavourite;
import Model.Products;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class ProductsFavouriteInsertServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductsFavouriteInsertServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductsFavouriteInsertServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String id_raw = request.getParameter("id");
        int productId = 0;
        try {
            productId = Integer.parseInt(id_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        ProductsDAO pd = new ProductsDAO();
        HttpSession sess = request.getSession();
        User x = (User) sess.getAttribute("account");//lấy account user từ session
        ProductsFavouriteDAO u = new ProductsFavouriteDAO();
        //check product đã được tồn tại trong danh sách yêu thích hay chưa

        if (sess.getAttribute("account") == null) { //nếu chưa đăng nhập
            out.print("Vui lòng đăng nhập để thực hiện thao tác thêm sản phẩm yêu thích!");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            ProductFavourite pf = u.getPfById(productId, x.getId()); //nếu user đã đăng nhập, get sản phẩm đã yêu thích
            if (pf != null) {//check pf khác null thì không cho insert vào bảng.
                List<Products> list = u.getListByUserName(x.getId()); //getlistproduct đã đc user yêu thích
                Products p = pd.getProductsById(productId);//get sản phẩm theo id
                String np = p.getTitle();
                String report = "Sản phẩm " + np + " đã được thêm vào yêu thích, không thể thêm 2 lần!";
                request.setAttribute("report", report);
                request.setAttribute("list", list);
                request.getRequestDispatcher("favourite.jsp").forward(request, response);
            } else {//nếu không null. thì insert vào bảng favourite
                int userId = x.getId();
                u.insertProductFavourite(userId, productId);
                request.getRequestDispatcher("shop.jsp").forward(request, response);
            }
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
