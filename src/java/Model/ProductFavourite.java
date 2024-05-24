
package Model;

public class ProductFavourite {
    private int id;
    private int userID;
    private int productID;
    
    public ProductFavourite(){}

    public ProductFavourite(int id, int userID, int productID) {
        this.id = id;
        this.userID = userID;
        this.productID = productID;
    }

    public ProductFavourite(int userID, int productID) {
        this.userID = userID;
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "ProductFavourite{" + "id=" + id + ", userID=" + userID + ", productID=" + productID + '}';
    }
}
