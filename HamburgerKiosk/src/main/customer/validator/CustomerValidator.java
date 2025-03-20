package main.customer.validator;

import main.customer.Customer;
import main.customer.CustomerService;

import java.util.List;

import static main.customer.validator.CustomerErrorMessage.*;

public class CustomerValidator {

    private CustomerValidator() {}

    public static void createValidator(String[] customerData, List<Customer> customers) {
        validateLength(customerData);
        validateNumberFormat(customerData);
        validateIsNegative(customerData);
        validateDuplicateCustomer(customerData, customers);
    }

    private static void validateLength(String[] customerData) {
        if (customerData.length != 2) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private static void validateNumberFormat(String[] customerData) {
        try {
            Integer.parseInt(customerData[1].trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    private static void validateIsNegative(String[] customerData) {
        if (Integer.parseInt(customerData[1].trim()) < 0) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_NUMBER.getMessage());
        }
    }

    private static void validateDuplicateCustomer(String[] customerData, List<Customer> customers) {
       if (customers.stream().anyMatch(customer -> customer.getId().equals(customerData[0].trim()))) {
            throw new IllegalArgumentException(DUPLICATE_CUSTOMER.getMessage());
        }

    }
}