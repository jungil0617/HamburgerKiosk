package main.kiosk;

import main.customer.Customer;
import main.customer.CustomerService;
import main.admin.Admin;
import main.admin.AdminService;
import main.io.Input;
import main.io.InputMessage;
import main.menu.ProductService;
import main.order.OrderService;
import main.order.Payment;

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
        intro(admin, customer);
        productService.showProducts();
        orderService.orderMenu();
        payment.processPayment(orderService.getOrders(), admin, customer);
        productService.updateProducts();
        handleNextStep(admin, customer);
    }

    private void intro(Admin admin, Customer customer) {
        System.out.println("=================================");
        System.out.println("안녕하세요. " + customer.getCustomerId() + "님 햄버거 가게 입니다.");
        System.out.println("현재 접속된 관리자는 " + admin.getAdminName() + "입니다.");
    }

    private String outro() {
        System.out.println("감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)");
        return Input.nextLine();
    }

    private void handleNextStep(Admin admin, Customer customer) {
        String choice = outro();

        if(choice.equals("Y")) {
            startOrder(admin, customer);
        } else {
            adminService.logoutAdmin();
            customerService.logoutCustomer();
            start();
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