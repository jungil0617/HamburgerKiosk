package main.customer;

import main.customer.validator.CustomerValidator;
import main.io.Input;
import java.util.ArrayList;
import java.util.List;

import static main.customer.validator.CustomerErrorMessage.CUSTOMER_NOT_FOUND;
import static main.io.InputMessage.*;
import static main.util.Separator.COMMA;

public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();
    private Customer loggedInCustomer;

    public void createCustomer() {
        System.out.println(CREATE_CUSTOMER.getMessage());
        String[] customerInput = Input.nextLine().split(COMMA.getSeparator());

        CustomerValidator.createValidator(customerInput, customers);

        String id = customerInput[0];
        int money = Integer.parseInt(customerInput[1].trim());

        Customer customer = new Customer(id, money);
        customers.add(customer);
    }

    public void loginCustomer() {
        System.out.println(LOGIN_CUSTOMER.getMessage());
        String id = Input.nextLine();

        for(Customer customer : customers) {
            if(id.equals(customer.getId())) {
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