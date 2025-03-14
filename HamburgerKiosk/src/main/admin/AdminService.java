package main.admin;

import main.admin.validator.AdminValidator;
import main.io.Input;
import java.util.ArrayList;
import java.util.List;

import static main.admin.AdminIndex.MONEY;
import static main.admin.AdminIndex.NAME;
import static main.admin.validator.AdminErrorMessage.ADMIN_NOT_FOUND;
import static main.util.Separator.COMMA;

public class AdminService {

    private final List<Admin> admins = new ArrayList<>();
    private Admin loggedInAdmin;
    Admin admin;

    public void createAdmin() {
        System.out.println("관리자 이름과 잔액을 입력해주세요.");
        String[] adminInput = Input.nextLine().split(COMMA.getSeparator());

        AdminValidator.createValidator(adminInput, admins);

        String name = adminInput[NAME.getIndex()];
        int money = Integer.parseInt(adminInput[MONEY.getIndex()].trim());

        admin = new Admin(name, money);
        admins.add(admin);
    }

    public void loginAdmin() {
        System.out.println("로그인할 관리자 이름을 입력해주세요.");
        String name = Input.nextLine();

        for(Admin admin : admins) {
            if(admin.getAdminName().equals(name)) {
                loggedInAdmin = admin;
                return;
            }
        }
        throw new IllegalArgumentException(ADMIN_NOT_FOUND.getMessage());
    }

    public void logoutAdmin() {
        loggedInAdmin = null;
    }

    public Admin getLoggedInAdmin() {
        return loggedInAdmin;
    }

    public boolean isAdminLoggedIn() {
        return loggedInAdmin != null;
    }

}