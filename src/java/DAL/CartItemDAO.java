package DAL;

import Model.CartItem;
import Model.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartItemDAO extends DBContext {

    public void insertCartItem(int cartId, int productId, int quantity) {
        String sql = "INSERT INTO [dbo].[CartItem]\n"
                + "           ([CartID]\n"
                + "           ,[ProductID]\n"
                + "           ,[Quantity])\n"
                + "     VALUES (?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartId);
            st.setInt(2, productId);
            st.setInt(3, quantity);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<CartItem> getListCartByCid(int cartId) {
        List<CartItem> list = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "          ,[CartID]\n"
                + "           ,[ProductID]\n"
                + "           ,[Quantity]\n"
                + "    FROM [dbo].[CartItem]"
                + "    WHERE CartID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartId);
            ResultSet rs = st.executeQuery();
            CartItem c = null;
            while (rs.next()) {
                CartDAO cu = new CartDAO();
                ProductsDAO p = new ProductsDAO();
                c = new CartItem(rs.getInt("ID"), cu.getCartByCiId(rs.getInt("CartID")), p.getProductsById(rs.getInt("ProductID")), rs.getInt("Quantity"));
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<CartItem> getListCartItem(int cartId) {
        List<CartItem> list = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[CartID]\n"
                + "      ,[ProductID]\n"
                + "      ,[Quantity]\n"
                + "  FROM [dbo].[CartItem]"
                + "  Where CartID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartId);
            ResultSet rs = st.executeQuery();
            CartItem c = null;
            while (rs.next()) {
                CartDAO cu = new CartDAO();
                ProductsDAO p = new ProductsDAO();
                c = new CartItem(rs.getInt("ID"), cu.getCartByCiId(rs.getInt("CartID")), p.getProductsById(rs.getInt("ProductID")), rs.getInt("Quantity"));
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteCartItemByPid(int pid, int cartId) {
        String sql = "DELETE FROM [dbo].[CartItem]\n"
                + "      WHERE ProductID = ? AND CartId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.setInt(2, cartId);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public CartItem getCartItemByPUid(int productId, int userId) { //check nếu tồn tại product rồi sẽ update số lượng 
        String sql = "SELECT [ID]\n"
                + "      ,c.[CartID]\n"
                + "      ,[ProductID]\n"
                + "      ,[Quantity]\n"
                + "  FROM [dbo].[CartItem] c\n"
                + "  INNER JOIN Cart k on k.CartID = c.CartID\n"
                + "  INNER JOIN CUser u on u.UserID = k.UserID\n"
                + "  WHERE k.UserID = ? AND ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, productId);
            ResultSet rs = st.executeQuery();
            CartItem c = null;
            if (rs.next()) {
                CartDAO cu = new CartDAO();
                ProductsDAO p = new ProductsDAO();
                c = new CartItem(rs.getInt("ID"), cu.getCartByCiId(rs.getInt("CartID")), p.getProductsById(rs.getInt("ProductID")), rs.getInt("Quantity"));
            }
            return c;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateQuantityCartItem(int Cid, int nquantity) {
        String sql = "UPDATE [dbo].[CartItem]\n"
                + "   SET [Quantity] = ?\n"
                + " WHERE ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, nquantity);
            st.setInt(2, Cid);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCartItemDaoByCid(int cartId) {
        String sql = "DELETE FROM [dbo].[CartItem]\n"
                + "      WHERE CartID = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartId);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CartItemDAO u = new CartItemDAO();
        u.insertCartItem(2, 1, 1);
        u.updateQuantityCartItem(0, 0);
    }
}
