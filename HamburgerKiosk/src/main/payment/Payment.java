package main.payment;

import main.admin.Admin;
import main.customer.Customer;
import main.io.Output;
import main.order.Order;
import main.order.OrderService;

import java.util.List;

public class Payment {

    public void processPayment(List<Order> orders, Admin admin, Customer customer) {
        int totalAmount = OrderService.calculateTotalPrice(orders);
        int totalQuantity = OrderService.calculateTotalQuantity(orders);

        customer.updateMoney(totalAmount);
        admin.updateMoney(totalAmount);

        Output.displayReceipt(orders, totalAmount, totalQuantity, admin, customer);
    }

}