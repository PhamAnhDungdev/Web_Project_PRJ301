package DAL;

import Model.Categories;
import Model.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ProductsDAO extends DBContext {

    public List<Products> getAllProducts() {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT [ProductID]\n"
                + "      ,[Name]\n"
                + "      ,[Price]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Describe]\n"
                + "      ,[ReleaseDate]\n"
                + "      ,[CategoriesID]\n"
                + "  FROM [dbo].[Products]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriesDAO cdao = new CategoriesDAO();
                Products pro = new Products(rs.getInt("ProductID"), rs.getString("name"),
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
        return list;
    }

    public Products getProductsById(int id) {
        String sql = "SELECT [ProductID]\n"
                + "      ,[Name]\n"
                + "      ,[Price]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Describe]\n"
                + "      ,[ReleaseDate]\n"
                + "      ,[CategoriesID]\n"
                + "  FROM [dbo].[Products]"
                + "Where ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            Products pro = null;
            if (rs.next()) {
                CategoriesDAO cdao = new CategoriesDAO();
                pro = new Products(rs.getInt("ProductID"), rs.getString("name"),
                        rs.getDouble("Price"),
                        rs.getString("Title"),
                        rs.getString("Image"),
                        rs.getString("Describe"),
                        rs.getDate("ReleaseDate"),
                        cdao.getCategoriesByID(rs.getInt("CategoriesID")));
            }
            return pro;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public List<Products> sortByIntervalAndOrder(double min, double max, String orderby, int cid) {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT [ProductID]\n"
                + "      ,[Name]\n"
                + "      ,[Price]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Describe]\n"
                + "      ,[ReleaseDate]\n"
                + "      ,[CategoriesID]\n"
                + "  FROM [dbo].[Products]"
                + "Where Price > ? AND Price <= ? \n";
        String cateID = " AND CategoriesID = " + cid + "\n";
        String order = " ORDER BY Price " + orderby;

        if (cid != 0) {
            sql += cateID + order;
        } else {
            sql += order;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, min);
            st.setDouble(2, max);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriesDAO cdao = new CategoriesDAO();
                Products pro = new Products(rs.getInt("ProductID"), rs.getString("name"),
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
        return list;
    }

    public List<Products> getListByCid(int cid) {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT [ProductID]\n"
                + "      ,[Name]\n"
                + "      ,[Price]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Describe]\n"
                + "      ,[ReleaseDate]\n"
                + "      ,[CategoriesID]\n"
                + "  FROM [dbo].[Products]"
                + "Where CategoriesID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriesDAO cdao = new CategoriesDAO();
                Products pro = new Products(rs.getInt("ProductID"), rs.getString("name"),
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

    public List<Products> getProductByName(String pname) {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT [ProductID]\n"
                + "      ,[Name]\n"
                + "      ,[Price]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Describe]\n"
                + "      ,[ReleaseDate]\n"
                + "      ,[CategoriesID]\n"
                + "  FROM [dbo].[Products]"
                + "  Where Name like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pname + "%");
            ResultSet rs = st.executeQuery();
            Products p = null;
            while (rs.next()) {
                CategoriesDAO cdao = new CategoriesDAO();
                p = new Products(rs.getInt("ProductID"), rs.getString("name"),
                        rs.getDouble("Price"),
                        rs.getString("Title"),
                        rs.getString("Image"),
                        rs.getString("Describe"),
                        rs.getDate("ReleaseDate"),
                        cdao.getCategoriesByID(rs.getInt("CategoriesID")));
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Products> getListByUserId(int userId) {// GET LIST PRODUCT THEO CART OF USER
        List<Products> list = new ArrayList<>();
        String sql = "SELECT p.[ProductID]\n"
                + "      ,[Name]\n"
                + "      ,[Price]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Describe]\n"
                + "      ,[ReleaseDate]\n"
                + "      ,[CategoriesID]\n"
                + "  FROM [dbo].[Products] p\n"
                + "  INNER JOIN CartItem c on p.ProductID = c.ProductID\n"
                + "  INNER JOIN Cart d on d.CartID = c.CartID\n"
                + "  INNER JOIN CUser k on d.UserID = k.UserID"
                + "  WHERE k.UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            Products p = null;
            while (rs.next()) {
                CategoriesDAO cdao = new CategoriesDAO();
                p = new Products(rs.getInt("ProductID"),
                        rs.getString("Name"),
                        rs.getDouble("Price"),
                        rs.getString("Title"),
                        rs.getString("Image"),
                        rs.getString("Describe"),
                        rs.getDate("ReleaseDate"),
                        cdao.getCategoriesByID(rs.getInt("CategoriesID")));
                list.add(p);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Products> orderByFavourite(int userId, int cid, String orderBy) {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT p.[ProductID]\n"
                + "      ,[Name]\n"
                + "      ,[Price]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Describe]\n"
                + "      ,[ReleaseDate]\n"
                + "      ,[CategoriesID]\n"
                + "  FROM [dbo].[Products] p\n"
                + "  INNER JOIN ProductFavourite f on f.ProductID = p.ProductID\n"
                + "  INNER JOIN CUser c on f.UserID = c.UserID\n"
                + "  Where f.UserID = ? ";
        if (cid != 0) {
            sql += " AND p.CategoriesID = " + cid;
        } else {
            sql += " ORDER BY p.Price " + orderBy;
        }

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriesDAO cdao = new CategoriesDAO();
                Products pro = new Products(rs.getInt("ProductID"),
                        rs.getString("name"),
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

    public List<Products> sortShopByOrder(int cid, String orderby) {
        List<Products> list = new ArrayList<>();
        String sql = "SELECT p.[ProductID]\n"
                + "      ,[Name]\n"
                + "      ,[Price]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Describe]\n"
                + "      ,[ReleaseDate]\n"
                + "      ,[CategoriesID]\n"
                + "  FROM [dbo].[Products] p\n";
        String order = " Order By Price " + orderby;
        if (cid != 0) {
            sql += " Where CategoriesID = " + cid + order;
        } else {
            sql += order;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoriesDAO cdao = new CategoriesDAO();
                Products pro = new Products(rs.getInt("ProductID"),
                        rs.getString("name"),
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

    public void updateProduct(Products p) {
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [Name] = ?\n"
                + "      ,[Price] = ?\n"
                + "      ,[Title] = ?\n"
                + "      ,[Image] = ?\n"
                + "      ,[Describe] = ?\n"
                + "      ,[ReleaseDate] = ?\n"
                + "      ,[CategoriesID] = ?\n"
                + " WHERE ProductID = ? ";
        java.sql.Date Registration = (java.sql.Date) p.getDate();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setString(3, p.getTitle());
            st.setString(4, p.getImage());
            st.setString(5, p.getDescribe());
            st.setDate(6, Registration);
            st.setInt(7, p.getCategory().getId());
            st.setInt(8, p.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void deleteProductsByCId(int cid) {
        String sql = "DELETE FROM [dbo].[Products]\n"
                + "      WHERE CategoriesID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            st.executeQuery();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteProducts(int pid) {
        String sql = "DELETE FROM [dbo].[Products]\n"
                + "      WHERE ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            st.executeQuery();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertProducts(Products p) {
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([Name]\n"
                + "           ,[Price]\n"
                + "           ,[Title]\n"
                + "           ,[Image]\n"
                + "           ,[Describe]\n"
                + "           ,[ReleaseDate]\n"
                + "           ,[CategoriesID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?)";
        java.sql.Date Registration = (java.sql.Date) p.getDate();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setString(3, p.getTitle());
            st.setString(4, p.getImage());
            st.setString(5, p.getDescribe());
            st.setDate(6, Registration);
            st.setInt(7, p.getCategory().getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ProductsDAO u = new ProductsDAO();
        List<Products> list = u.sortByIntervalAndOrder(0, 10000000, "ASC", 1);
        List<Products> list2 = u.sortShopByOrder(0, "ASC");
        //Products a = u.getProductByName("Tr");
        //System.out.println(list2);
        LocalDate localDate = LocalDate.now();
        java.sql.Date registration = java.sql.Date.valueOf(localDate);
        Categories c = new Categories(17, "Pham Anh Dung");
        Products p = new Products("ABC", 14.5, "ABC", "ABC", "ABC", registration, c);
        //u.insertProducts(p);
    }
}
