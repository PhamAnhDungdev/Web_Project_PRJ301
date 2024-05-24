package DAL;

import Model.Orders;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends DBContext {

    public void inserOrders(Orders order) {
        String sql = "INSERT INTO [dbo].[Orders]\n"
                + "           ([UserID]\n"
                + "           ,[FirstName]\n"
                + "           ,[LastName]\n"
                + "           ,[Phone]\n"
                + "           ,[Email]\n"
                + "           ,[Address]\n"
                + "           ,[Country]\n"
                + "           ,[OrderDate]\n"
                + "           ,[TotalAmount])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?)";
        java.sql.Date OrderDate = (java.sql.Date) order.getOrderDate();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, order.getUserID());
            st.setString(2, order.getFirstName());
            st.setString(3, order.getLastName());
            st.setString(4, order.getPhone());
            st.setString(5, order.getEmail());
            st.setString(6, order.getAddress());
            st.setString(7, order.getCountry());
            st.setDate(8, OrderDate);
            st.setDouble(9, order.getTotalamout());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Orders getOrderByOrID(int orderID) {
        String sql = "SELECT [OrderID]\n"
                + "      ,[UserID]\n"
                + "      ,[FirstName]\n"
                + "      ,[LastName]\n"
                + "      ,[Phone]\n"
                + "      ,[Email]\n"
                + "      ,[Address]\n"
                + "      ,[Country]\n"
                + "      ,[OrderDate]\n"
                + "      ,[TotalAmount]\n"
                + "  FROM [dbo].[Orders]"
                + "  WHERE OrderID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderID);
            ResultSet rs = st.executeQuery();
            Orders o = null;
            if (rs.next()) {
                o = new Orders(rs.getInt("lastOrder"),
                        rs.getInt("UserID"),
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Phone"),
                        rs.getString("Email"),
                        rs.getString("Address"),
                        rs.getString("Country"),
                        rs.getDate("OrderDate"),
                        rs.getDouble("TotalAmount"));
            }
            return o;
        } catch (Exception e) {
        }
        return null;
    }

    public int getOrderIDByUserID(int userID) {
        String sql = "SELECT MAX(OrderID) as lastOrder"
                + "     FROM Orders"
                + "     Where [UserID] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            int orderID = 0;
            if (rs.next()) {
                orderID = rs.getInt("lastOrder");
                return orderID;
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Orders> getAllOrders() {
        List<Orders> list = new ArrayList<>();
        String sql = "SELECT [OrderID]\n"
                + "      ,[UserID]\n"
                + "      ,[FirstName]\n"
                + "      ,[LastName]\n"
                + "      ,[Phone]\n"
                + "      ,[Email]\n"
                + "      ,[Address]\n"
                + "      ,[Country]\n"
                + "      ,[OrderDate]\n"
                + "      ,[TotalAmount]\n"
                + "  FROM [dbo].[Orders]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            Orders o = null;
            while(rs.next()){
                o = new Orders(rs.getInt("OrderID"), 
                        rs.getInt("UserID"), 
                        rs.getString("Firstname"), 
                        rs.getString("Lastname"), 
                        rs.getString("Phone"), 
                        rs.getString("Email"), 
                        rs.getString("Address"), 
                        rs.getString("Country"),
                        rs.getDate("OrderDate"), 
                        rs.getDouble("TotalAmount"));
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        OrdersDAO o = new OrdersDAO();
        LocalDate localDate = LocalDate.now();
        Date orderdate = Date.valueOf(localDate);
        //o.inserOrders(new Orders(3, "D", "A", "0987654321", "dunganh123@gmail.com", "hanam", "vietnam", orderdate, 220));
        System.out.println(o.getAllOrders());
    }
}
