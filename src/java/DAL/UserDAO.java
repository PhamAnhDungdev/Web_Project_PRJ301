package DAL;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DBContext {

    public User getUserByUserPass(String username, String password) {
        String sql = "SELECT [UserID]\n"
                + "      ,[First_Name]\n"
                + "      ,[Last_Name]\n"
                + "      ,[Phone]\n"
                + "      ,[Address]\n"
                + "      ,[Email]\n"
                + "      ,[Username]\n"
                + "      ,[Password]\n"
                + "      ,[Role]\n"
                + "      ,[Registration]\n"
                + "  FROM [dbo].[CUser]"
                + "Where Username = ? AND Password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            User u = null;
            if (rs.next()) {
                u = new User(rs.getInt("UserID"),
                        rs.getString("First_Name"),
                        rs.getString("Last_Name"),
                        rs.getString("Phone"),
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("Role"),
                        rs.getDate("Registration"));
            }
            return u;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT [UserID]\n"
                + "      ,[First_Name]\n"
                + "      ,[Last_Name]\n"
                + "      ,[Phone]\n"
                + "      ,[Address]\n"
                + "      ,[Email]\n"
                + "      ,[Username]\n"
                + "      ,[Password]\n"
                + "      ,[Role]\n"
                + "      ,[Registration]\n"
                + "  FROM [dbo].[CUser]"
                + "Where Username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            User u = null;
            if (rs.next()) {
                u = new User(rs.getString("First_Name"),
                        rs.getString("Last_Name"),
                        rs.getString("Phone"),
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("Role"),
                        rs.getDate("Registration"));
            }
            return u;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertUser(User u) {
        String sql = "INSERT INTO [dbo].[CUser]\n"
                + "           ([First_Name]\n"
                + "           ,[Last_Name]\n"
                + "           ,[Phone]\n"
                + "           ,[Address]\n"
                + "           ,[Email]\n"
                + "           ,[Username]\n"
                + "           ,[Password]\n"
                + "           ,[Role]\n"
                + "           ,[Registration])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        java.sql.Date Registration = (java.sql.Date) u.getRegistration();
//        java.util.Date utilRegistration = u.getRegistration();
//        java.sql.Date Registration = new java.sql.Date(utilRegistration.getTime());
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getFirstname());
            st.setString(2, u.getLastname());
            st.setString(3, u.getPhone());
            st.setString(4, u.getAddress());
            st.setString(5, u.getEmail());
            st.setString(6, u.getUsername());
            st.setString(7, u.getPassword());
            st.setInt(8, u.getRole());
            st.setDate(9, Registration);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public User getUserById(int userId) {
        String sql = "SELECT [UserID]\n"
                + "      ,[First_Name]\n"
                + "      ,[Last_Name]\n"
                + "      ,[Phone]\n"
                + "      ,[Address]\n"
                + "      ,[Email]\n"
                + "      ,[Username]\n"
                + "      ,[Password]\n"
                + "      ,[Role]\n"
                + "      ,[Registration]\n"
                + "  FROM [dbo].[CUser]"
                + "Where Username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            User u = null;
            if (rs.next()) {
                u = new User(rs.getString("First_Name"),
                        rs.getString("Last_Name"),
                        rs.getString("Phone"),
                        rs.getString("Address"),
                        rs.getString("Email"),
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getInt("Role"),
                        rs.getDate("Registration"));
            }
            return u;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateProfile(User x, int userID) {
        String sql = "UPDATE [dbo].[CUser]\n"
                + "   SET [First_Name] = ?\n"
                + "      ,[Last_Name] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Username] = ?\n"
                + "      ,[Password] = ?\n"
                + " WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, x.getFirstname());
            st.setString(2, x.getLastname());
            st.setString(3, x.getPhone());
            st.setString(4, x.getAddress());
            st.setString(5, x.getEmail());
            st.setString(6, x.getUsername());
            st.setString(7, x.getPassword());
            st.setInt(8, userID);
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        UserDAO u = new UserDAO();
        User c = u.getUserByUserPass("dunganh123", "123");
        //User d = u.getUserByUsername("d")
        System.out.println(c);
    }
}
