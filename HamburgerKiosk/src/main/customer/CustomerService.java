package main.customer;

import main.io.input.Input;
import main.io.input.InputMessage;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private final List<Customer> customers = new ArrayList<>();

    public void createCustomer() {
        System.out.print(InputMessage.CREATE_CUSTOMER.getMessage());
        String[] customerInput = Input.nextLine().split(",");
        if (customerInput.length != 2) {
            System.out.println("[ERROR] 올바른 형식으로 입력하세요.");
            return;
        }
        int customerId = Integer.parseInt(customerInput[0].trim());
        int customerMoney = Integer.parseInt(customerInput[1].trim());
        customers.add(new Customer(customerId, customerMoney));
        System.out.println("회원 생성 완료: " + customerId);
    }

    public void loginCustomer() {
        System.out.print(InputMessage.LOGIN_CUSTOMER.getMessage());
        int customerLoginId = Integer.parseInt(Input.nextLine());
        if (customers.stream().anyMatch(customer -> customer.getCustomerId() == customerLoginId)) {
            System.out.println("회원 로그인 완료: " + customerLoginId);
        } else {
            System.out.println("[ERROR] 존재하지 않는 회원입니다.");
        }
    }
}