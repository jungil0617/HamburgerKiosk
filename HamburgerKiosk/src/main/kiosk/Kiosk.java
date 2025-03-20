package main.kiosk;

import main.customer.Customer;
import main.customer.CustomerService;
import main.admin.Admin;
import main.admin.AdminService;
import main.io.Input;
import main.io.InputMessage;
import main.io.Output;
import main.menu.ProductService;
import main.order.OrderService;
import main.order.Payment;

import static main.io.InputMessage.*;
import static main.kiosk.Option.getOption;

public class Kiosk {

    private final CustomerService customerService = new CustomerService();
    private final AdminService adminService = new AdminService();
    private final ProductService productService = new ProductService();
    private final OrderService orderService = new OrderService(productService);
    private final Payment payment = new Payment();

    public void start() {
        productService.loadProducts();

        while(!adminService.isAdminLoggedIn() || !customerService.isCustomerLoggedIn()) {
            try {
                System.out.println(InputMessage.ROOT.getMessage());
                int option = Integer.parseInt(Input.nextLine());
                processSelect(option);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        startOrder(adminService.getLoggedInAdmin(), customerService.getLoggedInCustomer());
    }

    private void processSelect(int num) {
        Option option = getOption(num);
        switch (option) {
            case EXIT -> exitKiosk();
            case ADMIN_CREATE -> createAdmin();
            case ADMIN_LOGIN -> loginAdmin();
            case CUSTOMER_CREATE -> getCustomer();
            case CUSTOMER_LOGIN -> loginCustomer();
        }
    }

    private void startOrder(Admin admin, Customer customer) {
        Output.displayIntro(admin, customer);
        productService.showProducts();
        orderService.orderMenu();
        payment.processPayment(orderService.getOrders(), admin, customer);
        productService.updateProducts();
        handleNextStep(admin, customer);
    }

    private String extraOrder() {
        System.out.println(EXTRA_ORDER.getMessage());
        return Input.nextLine();
    }

    private void handleNextStep(Admin admin, Customer customer) {
        String choice = extraOrder();

        switch (choice) {
            case "Y" -> startOrder(admin, customer);
            case "N" -> {
                adminService.logoutAdmin();
                customerService.logoutCustomer();
                start();
            }
        }
    }

    private void exitKiosk() {
        System.exit(0);
    }

    private void loginCustomer() {
        customerService.loginCustomer();
    }

    private void getCustomer() {
        customerService.createCustomer();
    }

    private void loginAdmin() {
        adminService.loginAdmin();
    }

    private void createAdmin() {
        adminService.createAdmin();
    }

 }