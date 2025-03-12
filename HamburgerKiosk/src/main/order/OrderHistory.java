package main.order;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {

    private final List<Order> orderHistory = new ArrayList<>();

    public void addOrder(List<Order> orders) {
        orderHistory.addAll(orders);
    }

    public List<Order> getOrderHistory() {
        return new ArrayList<>(orderHistory);
    }

}