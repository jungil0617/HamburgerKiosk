package main.io;

import main.admin.Admin;
import main.customer.Customer;
import main.order.Order;

import java.util.List;

import static main.io.OutputMessage.DISPLAY_INTRO;

public class Output {

    public static void displayIntro(Admin admin, Customer customer) {
        System.out.printf(
                (DISPLAY_INTRO.getMessage()),
                customer.getCustomerId(), admin.getAdminName()
        );
    }

    public static void displayReceipt(List<Order> orders, int totalAmount, int totalQuantity, Admin admin, Customer customer) {
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

}