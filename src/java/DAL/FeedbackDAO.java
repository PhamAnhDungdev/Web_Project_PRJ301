package DAL;

import Model.Feedback;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO extends DBContext {

    public void insertFeedback(Feedback fb) {
        String sql = "INSERT INTO [dbo].[FeedbackProduct]\n"
                + "           ([ProductID]\n"
                + "           ,[Name]\n"
                + "           ,[Email]\n"
                + "           ,[DateReview]\n"
                + "           ,[Review])\n"
                + "     VALUES(?,?,?,?,?)";
        java.sql.Date FeedbackDate = (java.sql.Date) fb.getDatereview();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, fb.getProductID());
            st.setString(2, fb.getName());
            st.setString(3, fb.getEmail());
            st.setDate(4, FeedbackDate);
            st.setString(5, fb.getReview());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Feedback> getFeedbackByPid(int pid) {
        List<Feedback> list = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[ProductID]\n"
                + "      ,[Name]\n"
                + "      ,[Email]\n"
                + "      ,[DateReview]\n"
                + "      ,[Review]\n"
                + "  FROM [dbo].[FeedbackProduct]"
                + "  WHERE ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            ResultSet rs = st.executeQuery();
            Feedback f = null;
            while(rs.next()){
                f = new Feedback(rs.getInt("ProductID"),
                        rs.getString("Name"), 
                        rs.getString("Email"), 
                        rs.getDate("DateReview"), rs.getString("Review"));
                list.add(f);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Feedback> getAllFeedback(){
        List<Feedback> list = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[ProductID]\n"
                + "      ,[Name]\n"
                + "      ,[Email]\n"
                + "      ,[DateReview]\n"
                + "      ,[Review]\n"
                + "  FROM [dbo].[FeedbackProduct]";
         try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            Feedback f = null;
            while(rs.next()){
                f = new Feedback(rs.getInt("ID"),
                        rs.getInt("ProductID"),
                        rs.getString("Name"), 
                        rs.getString("Email"), 
                        rs.getDate("DateReview"), rs.getString("Review"));
                list.add(f);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        FeedbackDAO u = new FeedbackDAO();
        LocalDate localDate = LocalDate.now();
        Date DateReview = Date.valueOf(localDate);
        u.insertFeedback(new Feedback(1, "Anh Dung", "dungpham267@gmail.com", DateReview, "Đẹp vái chưởng"));
    }
}
