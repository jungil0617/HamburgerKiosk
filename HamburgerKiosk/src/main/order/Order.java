package main.order;

import main.menu.Product;

public class Order {

    private final Product product;
    private final int quantity;
    private final int totalPrice;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

}