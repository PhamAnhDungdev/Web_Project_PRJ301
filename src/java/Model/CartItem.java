
package Model;


public class CartItem {
    private int CartItemId;
    private Cart CartId;
    private Products Product;
    private int Quantity;
    
    public CartItem(){}

    public CartItem(int CartItemId, Cart CartId, Products Product, int Quantity) {
        this.CartItemId = CartItemId;
        this.CartId = CartId;
        this.Product = Product;
        this.Quantity = Quantity;
    }

    public CartItem(Cart CartId, Products Product, int Quantity) {
        this.CartId = CartId;
        this.Product = Product;
        this.Quantity = Quantity;
    }

    public int getCartItemId() {
        return CartItemId;
    }

    public void setCartItemId(int CartItemId) {
        this.CartItemId = CartItemId;
    }

    public Cart getCartId() {
        return CartId;
    }

    public void setCartId(Cart CartId) {
        this.CartId = CartId;
    }

    public Products getProduct() {
        return Product;
    }

    public void setProduct(Products Product) {
        this.Product = Product;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" + "CartItemId=" + CartItemId + ", CartId=" + CartId + ", Product=" + Product + ", Quantity=" + Quantity + '}';
    }
}
