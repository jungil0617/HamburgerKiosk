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

    private void processSelect(int option) {
        // enum 대체 가능할거 같음
        switch (option) {
            case 0 -> exitKiosk();
            case 1 -> adminService.createAdmin();
            case 2 -> adminService.loginAdmin();
            case 3 -> customerService.createCustomer();
            case 4 -> customerService.loginCustomer();
            default -> System.out.println("[ERROR] 올바른 메뉴 번호를 입력해주세요.");
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

 }