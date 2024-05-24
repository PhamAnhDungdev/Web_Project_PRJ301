package DAL;

import Model.OrderDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO extends DBContext {

    public void inserOrderDetail(OrderDetails od) {
        String sql = "INSERT INTO [dbo].[OrderDetails]\n"
                + "           ([OrderID]\n"
                + "           ,[ProductID]\n"
                + "           ,[Quantity]\n"
                + "           ,[Subtotal])\n"
                + "     VALUES(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, od.getOrderID());
            st.setInt(2, od.getProductID());
            st.setInt(3, od.getQuantity());
            st.setDouble(4, od.getSubtotal());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<OrderDetails> getOrderDetailById(int orderID) {
        List<OrderDetails> list = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[OrderID]\n"
                + "      ,[ProductID]\n"
                + "      ,[Quantity]\n"
                + "      ,[Subtotal]\n"
                + "  FROM [dbo].[OrderDetails]"
                + "  Where OrderID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, orderID);
            ResultSet rs = st.executeQuery();
            OrderDetails o = null;
            while(rs.next()){
                o = new OrderDetails(rs.getInt("ID"), rs.getInt("OrderID"), rs.getInt("ProductID"), rs.getInt("Quantity"), rs.getDouble("Subtotal"));
                list.add(o);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        OrderDetailDAO o = new OrderDetailDAO();
        o.inserOrderDetail(new OrderDetails(1, 1, 1, 200));
    }
}
