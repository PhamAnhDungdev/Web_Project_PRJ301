/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Categories;
import Model.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO extends DBContext {

    public Categories getCategoriesByID(int cid) {
        String sql = "SELECT [CategoriesID]\n"
                + "      ,[Name]\n"
                + "  FROM [dbo].[Categories]"
                + "Where CategoriesID = ?";
        Categories cate = null;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                cate = new Categories(rs.getInt("CategoriesID"), rs.getString("name"));
                return cate;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return cate;
    }

    public List<Categories> getListCategories() {
        List<Categories> list = new ArrayList<>();
        String sql = "SELECT * FROM Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            Categories c = null;
            while (rs.next()) {
                c = new Categories(rs.getInt("CategoriesID"), rs.getString("Name"));
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public void addCategories(String cname) {
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([Name])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cname);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateCategories(int id, String name) {
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [Name] = ?\n"
                + " WHERE CategoriesID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setInt(2, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCategories(int id) {
        String sql = "DELETE FROM [dbo].[Categories]\n"
                + "      WHERE CategoriesID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        CategoriesDAO u = new CategoriesDAO();
        Categories list = u.getCategoriesByID(1);
        CategoriesDAO c = new CategoriesDAO();
        List<Categories> listc = (List<Categories>) c.getListCategories();
        System.out.println(listc);
    }
}
