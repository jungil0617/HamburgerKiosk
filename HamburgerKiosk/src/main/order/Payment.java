package main.order;

import main.admin.Admin;
import main.customer.Customer;
import main.io.Output;

import java.util.List;

public class Payment {

    public void processPayment(List<Order> orders, Admin admin, Customer customer) {
        int totalAmount =  orders.stream()
                .mapToInt(Order::getTotalPrice)
                .sum();

        int totalQuantity = calculateTotalQuantity(orders);

        customer.updateMoney(totalAmount);
        admin.updateMoney(totalAmount);

        Output.displayReceipt(orders, totalAmount, totalQuantity, admin, customer);
    }

    private int calculateTotalQuantity(List<Order> orders) {
        return orders.stream()
                .mapToInt(Order::getQuantity)
                .sum();
    }

}