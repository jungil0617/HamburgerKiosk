package main.menu;

public class Product {

    private final String name;
    private final int price;
    private int quantity;
    private final String description;
    private final Category category;

    public Product(String name, int price, int quantity, String description, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public void updateQuantity(int quantity) {
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return String.format("-%s, %d원, %s, %s",
                name,
                price,
                (quantity > 0 ? quantity + "개" : "품절"),
                description
        );
    }

}