package main.menu;

import main.file.ProductFileLoader;
import java.util.*;
import static main.util.Separator.COMMA;
import static main.util.Separator.QUOTES;

public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public void loadProducts() {
        List<String> productData = ProductFileLoader.load();

        for(String line : productData) {
            String[] data = line.split(COMMA.getSeparator());

            String name = data[0];
            int price = Integer.parseInt(data[1]);
            int quantity;
            if (Objects.equals(data[2], "재고없음")) {
                quantity = 0;
            } else {
                quantity = Integer.parseInt(data[2]);
            }
            String description = data[3].replaceAll(QUOTES.getSeparator(), "");
            Category category = Category.fromString(data[4]);

            products.add(new Product(name, price, quantity, description, category));
        }
    }

    public Product getProductByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public void showProducts() {
        // Category 에서 BURGER, SET 묶어서 출력, 더 좋은 방법이 있을거 같다...
        printCategory("햄버거", Category.BURGER, Category.SET);
        printCategory("사이드", Category.SIDE);
        printCategory("음료수", Category.DRINK);
    }

    private void printCategory(String title, Category... categories) {
        System.out.println("\n=" + title + "=");
        products.stream()
                .filter(product -> Arrays.asList(categories).contains(product.getCategory()))
                .forEach(product -> System.out.printf("- %s, %d원, %s, %s\n",
                        product.getName(),
                        product.getPrice(),
                        (product.getQuantity() > 0 ? product.getQuantity() + "개" : "품절"),
                        product.getDescription()));
    }


    public void updateProducts() {
        ProductFileLoader.save(products);
    }

}