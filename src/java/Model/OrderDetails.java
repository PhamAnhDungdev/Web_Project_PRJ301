
package Model;

public class OrderDetails {
    private int Id;
    private int orderID;
    private int ProductID;
    private int Quantity;
    private double Subtotal;
    
    public OrderDetails(){}

    public OrderDetails(int Id, int orderID, int ProductID, int Quantity, double Subtotal) {
        this.Id = Id;
        this.orderID = orderID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.Subtotal = Subtotal;
    }

    public OrderDetails(int orderID, int ProductID, int Quantity, double Subtotal) {
        this.orderID = orderID;
        this.ProductID = ProductID;
        this.Quantity = Quantity;
        this.Subtotal = Subtotal;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrder(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(double Subtotal) {
        this.Subtotal = Subtotal;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "Id=" + Id + ", order=" + orderID + ", ProductID=" + ProductID + ", Quantity=" + Quantity + ", Subtotal=" + Subtotal + '}';
    }
    
    
}
