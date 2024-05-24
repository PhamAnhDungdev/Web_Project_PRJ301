
package Model;
import java.util.Date;

public class Orders {
    private int OrderID;
    private int UserID;
    private String FirstName;
    private String LastName;
    private String Phone;
    private String Email;
    private String address;
    private String country;
    private Date OrderDate;
    private double totalamout;
    
    public Orders(){}

    public Orders(int OrderID, int UserID, String FirstName, String LastName, String Phone, String Email, String address, String country, Date OrderDate, double totalamout) {
        this.OrderID = OrderID;
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.address = address;
        this.country = country;
        this.OrderDate = OrderDate;
        this.totalamout = totalamout;
    }

    public Orders(int UserID, String FirstName, String LastName, String Phone, String Email, String address, String country, Date OrderDate, double totalamout) {
        this.UserID = UserID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.address = address;
        this.country = country;
        this.OrderDate = OrderDate;
        this.totalamout = totalamout;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public double getTotalamout() {
        return totalamout;
    }

    public void setTotalamout(double totalamout) {
        this.totalamout = totalamout;
    }

    @Override
    public String toString() {
        return "Orders{" + "OrderID=" + OrderID + ", UserID=" + UserID + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Phone=" + Phone + ", Email=" + Email + ", address=" + address + ", country=" + country + ", OrderDate=" + OrderDate + ", totalamout=" + totalamout + '}';
    }

    
    
}
