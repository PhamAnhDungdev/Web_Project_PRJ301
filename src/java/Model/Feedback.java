
package Model;

import java.util.Date;

public class Feedback {
    private int Id;
    private int ProductID;
    private String Name;
    private String Email;
    private Date Datereview;
    private String Review;
    
    public Feedback(){}

    public Feedback(int Id, int ProductID, String Name, String Email, Date Datereview, String Review) {
        this.Id = Id;
        this.ProductID = ProductID;
        this.Name = Name;
        this.Email = Email;
        this.Datereview = Datereview;
        this.Review = Review;
    }

    public Feedback(int ProductID, String Name, String Email, Date Datereview, String Review) {
        this.ProductID = ProductID;
        this.Name = Name;
        this.Email = Email;
        this.Datereview = Datereview;
        this.Review = Review;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getDatereview() {
        return Datereview;
    }

    public void setDatereview(Date Datereview) {
        this.Datereview = Datereview;
    }

    public String getReview() {
        return Review;
    }

    public void setReview(String Review) {
        this.Review = Review;
    }

    @Override
    public String toString() {
        return "Feedback{" + "Id=" + Id + ", ProductID=" + ProductID + ", Name=" + Name + ", Email=" + Email + ", Datereview=" + Datereview + ", Review=" + Review + '}';
    }
 
}
