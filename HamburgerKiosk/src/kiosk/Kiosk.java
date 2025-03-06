package kiosk;

import admin.AdminService;
import customer.CustomerService;
import file.LoadFile;
import io.input.Input;
import io.input.InputMessage;

import static kiosk.Option.getOption;

public class Kiosk {
    AdminService adminService = new AdminService();
    CustomerService customerService = new CustomerService();
    LoadFile loadFile = new LoadFile();

    public void start() {
        while (true) {
            System.out.print(InputMessage.ROOT.getMessage());
            int optionNum = Integer.parseInt(Input.nextLine());
            selectOption(optionNum);
        }
    }

    private void fileLoad() {
    }

    private void selectOption(int optionNum) {
        Option option = getOption(optionNum);
        switch (option) {
            case EXIT -> exit();
            case CREATE_ADMIN -> adminService.createAdmin();
            case LOGIN_ADMIN -> adminService.loginAdmin();
            case CREATE_CUSTOMER -> customerService.createCustomer();
            case LOGIN_CUSTOMER -> customerService.loginCustomer();
        }
    }

    private void exit() {
        System.exit(1);
    }
}