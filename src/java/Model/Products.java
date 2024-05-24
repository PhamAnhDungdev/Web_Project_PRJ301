
package Model;

import java.util.Date;
import java.util.Locale.Category;

public class Products {
    private int id;
    private String name;
    private Double price;
    private String title;
    private String image;
    private String describe;
    private Date Date;
    private Categories categories;
    
    public Products(){}

    public Products(int id, String name, Double price, String title, String image, String describe, Date Date, Categories categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.title = title;
        this.image = image;
        this.describe = describe;
        this.Date = Date;
        this.categories = categories;
    }

    public Products(String name, Double price, String title, String image, String describe, Date Date, Categories categories) {
        this.name = name;
        this.price = price;
        this.title = title;
        this.image = image;
        this.describe = describe;
        this.Date = Date;
        this.categories = categories;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Categories getCategory() {
        return categories;
    }

    public void setCategory(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", name=" + name + ", price=" + price + ", title=" + title + ", image=" + image + ", describe=" + describe + ", Date=" + Date + ", categories=" + categories + '}';
    }

    

    
    
    
}
