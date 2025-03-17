package main.customer;

import main.customer.validator.CustomerValidator;
import main.io.Input;
import java.util.ArrayList;
import java.util.List;

import static main.customer.validator.CustomerErrorMessage.CUSTOMER_NOT_FOUND;
import static main.util.Separator.COMMA;

public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();
    private Customer loggedInCustomer;
    Customer customer;

    public void createCustomer() {
        System.out.println("회원 번호와 잔액을 입력해주세요.");
        String[] customerInput = Input.nextLine().split(COMMA.getSeparator());

        CustomerValidator.createValidator(customerInput, customers);

        int id = Integer.parseInt(customerInput[0]);
        int money = Integer.parseInt(customerInput[1].trim());

        customer = new Customer(id, money);
        customers.add(customer);
    }

    public void loginCustomer() {
        System.out.println("로그인할 회원 번호를 입력해주세요.");
        int id = Integer.parseInt(Input.nextLine());

        for(Customer customer : customers) {
            if(customer.getCustomerId() == id) {
                loggedInCustomer = customer;
                return;
            }
        }
        throw new IllegalArgumentException(CUSTOMER_NOT_FOUND.getMessage());
    }

    public void logoutCustomer() {
        loggedInCustomer = null;
    }

    public Customer getLoggedInCustomer() {
        return loggedInCustomer;
    }

    public boolean isCustomerLoggedIn() {
        return loggedInCustomer != null;
    }

}