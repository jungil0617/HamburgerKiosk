package main.order;

import main.admin.Admin;
import main.customer.Customer;

import java.util.List;

public class Payment {

    public void processPayment(List<Order> orders, Admin admin, Customer customer) {
        int totalAmount =  orders.stream()
                .mapToInt(Order::getTotalPrice)
                .sum();

        int totalQuantity = calculateTotalQuantity(orders);

        customer.updateMoney(totalAmount);
        admin.updateMoney(totalAmount);

        printReceipt(orders, totalAmount, totalQuantity, admin, customer);
    }

    private void printReceipt(List<Order> orders, int totalAmount, int totalQuantity, Admin admin, Customer customer) {
        System.out.println("\n=====================");
        System.out.printf("%-10s %-5s %s%n", "상품명", "수량", "금액");

        for (Order order : orders) {
            System.out.printf("%-10s %-5d %,d원%n",
                    order.getProduct().getName(),
                    order.getQuantity(),
                    order.getTotalPrice());
        }

        System.out.println("=====================");
        System.out.printf("총구매액 %-5d %,d원%n", totalQuantity, totalAmount);
        System.out.println("=====================");

        System.out.printf("판매자: %s, %,d원%n", admin.getAdminName(), admin.getMoney()); // 관리자 정보 필요
        System.out.printf("구매자: %d, %,d원%n", customer.getCustomerId(), customer.getMoney());

    }

    private int calculateTotalQuantity(List<Order> orders) {
        return orders.stream()
                .mapToInt(Order::getQuantity)
                .sum();
    }

}