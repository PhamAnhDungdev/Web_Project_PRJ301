package DAL;

import Model.Cart;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartDAO extends DBContext {

    public void insertCart(int userId) {
        String sql = "INSERT INTO [dbo].[Cart] ([UserID]) "
                + "VALUES (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.executeUpdate();
            st.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Cart getCartByUid(int userId) {
        String sql = "SELECT [CartID]\n"
                + "      ,[UserID]\n"
                + "  FROM [dbo].[Cart]"
                + "  WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            Cart c = null;
            if (rs.next()) {
                c = new Cart(rs.getInt("CartID"), rs.getInt("UserID"));
            }
            return c;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Cart getCartByCiId(int cid) {
        String sql = "SELECT [CartID]\n"
                + "      ,[UserID]\n"
                + "  FROM [dbo].[Cart]"
                + "  WHERE CartID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            Cart c = null;
            if (rs.next()) {
                c = new Cart(rs.getInt("CartID"), rs.getInt("UserID"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteByCartItemID(int cartIid) {
        String sql = "DELETE FROM [dbo].[Cart]\n"
                + "      WHERE CartID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cartIid);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCartByUid(int userID) {
        String sql = "DELETE FROM [dbo].[Cart]\n"
                + "      WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        CartDAO u = new CartDAO();
        System.out.println(u.getCartByUid(3));
    }
}
