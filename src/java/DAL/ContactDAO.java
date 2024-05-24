package DAL;

import Model.Contact;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO extends DBContext {

    public void insertContact(Contact c) {
        String sql = "INSERT INTO [dbo].[Contact]\n"
                + "           ([Name]\n"
                + "           ,[Title]\n"
                + "           ,[Email]\n"
                + "           ,[Message])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getName());
            st.setString(3, c.getEmail());
            st.setString(4, c.getMessage());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Contact> getAllContact() {
        List<Contact> list = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[Name]\n"
                + "      ,[Title]\n"
                + "      ,[Email]\n"
                + "      ,[Message]\n"
                + "  FROM [dbo].[Contact]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            Contact c = null;
            while(rs.next()){
                c = new Contact(rs.getInt("ID"), rs.getString("Name"), rs.getString("Title"), rs.getString("Email"), rs.getString("Message"));
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
