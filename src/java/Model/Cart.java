
package Model;

public class Cart {
    private int CartId;
    private int UserId;
    
    public Cart(){}

    public Cart(int CartId, int UserId) {
        this.CartId = CartId;
        this.UserId = UserId;
    }

    public Cart(int UserId) {
        this.UserId = UserId;
    }

    public int getCartId() {
        return CartId;
    }

    public void setCartId(int CartId) {
        this.CartId = CartId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    @Override
    public String toString() {
        return "Cart{" + "CartId=" + CartId + ", UserId=" + UserId + '}';
    } 
}
