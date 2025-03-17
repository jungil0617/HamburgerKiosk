package main.order;

import main.io.Input;
import main.menu.Product;
import main.menu.ProductService;
import main.order.validator.OrderValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static main.util.Separator.*;

public class OrderService {

    private final List<Order> orders = new ArrayList<>();
    private final ProductService productService;

    public OrderService(ProductService productService) {
        this.productService = productService;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void orderMenu() {
        resetOrders();
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [치킨버거-3],[불고기버거세트-2])");
        String input = Input.nextLine();

        processOrder(input);
    }

    private void processOrder(String input) {
        input = input.replaceAll(Pattern.quote(OPEN_SQUARE_BRACKETS.getSeparator()), "")
                     .replaceAll(Pattern.quote(CLOSE_SQUARE_BRACKETS.getSeparator()), "");

        String[] separatedOrderMenu = input.split(COMMA.getSeparator());

        for(String orderMenu : separatedOrderMenu) {
            String[] parts = orderMenu.split(HYPHEN.getSeparator());

            OrderValidator.createValidator(parts, productService);

            String productName = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            Product product = productService.getProductByName(productName);

            product.updateQuantity(quantity);

            orders.add(new Order(product, quantity));
        }
    }

    private void resetOrders() {
        orders.clear();
    }

}