package DAL;

import Model.ProductFavourite;
import Model.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductsFavouriteDAO extends DBContext {

    public void insertProductFavourite(int userId, int productId) {
        String sql = "INSERT INTO [dbo].[ProductFavourite]\n"
                + "           ([UserID]\n"
                + "           ,[ProductID])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, productId);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Products> getListByUserName(int userid) {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT \n"
                + "    Products.ProductID,\n"
                + "    Products.Name,\n"
                + "    Products.Price,\n"
                + "    Products.Title,\n"
                + "    Products.Image,\n"
                + "    Products.Describe,\n"
                + "    Products.ReleaseDate,\n"
                + "    Products.CategoriesID\n"
                + "FROM \n"
                + "    dbo.Products\n"
                + "INNER JOIN \n"
                + "    ProductFavourite p ON Products.ProductID = p.ProductID\n"
                + "WHERE \n"
                + "    p.UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriesDAO cdao = new CategoriesDAO();
                Products pro = new Products(rs.getInt("ProductID"),
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getString("Title"),
                        rs.getString("Image"),
                        rs.getString("Describe"),
                        rs.getDate("ReleaseDate"),
                        cdao.getCategoriesByID(rs.getInt("CategoriesID")));
                list.add(pro);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public ProductFavourite getPfById(int pid, int userId) {
        String sql = "SELECT * FROM ProductFavourite Where ProductID = ? AND UserID = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.setInt(2, userId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ProductFavourite pf = new ProductFavourite(rs.getInt("ID"), rs.getInt("UserID"), rs.getInt("ProductID"));
                return pf;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteProductFavourite(int userId, int productId) {
        String sql = "DELETE FROM [dbo].[ProductFavourite]\n"
                + "      WHERE UserID = ? AND ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, productId);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ProductsFavouriteDAO u = new ProductsFavouriteDAO();
        ProductFavourite p = new ProductFavourite(4, 1);
        //u.insertProductFavourite(4,1);

        //ProductFavourite u1 = u.getPfById(1);
       // System.out.println(u1);
    }
}
