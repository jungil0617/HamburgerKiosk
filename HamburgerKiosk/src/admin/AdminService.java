package admin;

import io.input.Input;
import io.input.InputMessage;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    private final List<Admin> admins = new ArrayList<>();

    public void createAdmin() {
        System.out.print(InputMessage.CREATE_ADMIN.getMessage());
        String[] adminInput = Input.nextLine().split(",");
        if (adminInput.length != 2) {
            System.out.println("[ERROR] 올바른 형식으로 입력하세요.");
            return;
        }
        String adminName = adminInput[0].trim();
        int adminMoney = Integer.parseInt(adminInput[1].trim());
        admins.add(new Admin(adminName, adminMoney));
        System.out.println("관리자 생성 완료: " + adminName);
    }

    public void loginAdmin() {
        System.out.print(InputMessage.LOGIN_ADMIN.getMessage());
        String adminLogin = Input.nextLine();
        if (admins.stream().anyMatch(admin -> admin.getName().equals(adminLogin))) {
            System.out.println("관리자 로그인 완료: " + adminLogin);
        } else {
            System.out.println("[ERROR] 존재하지 않는 관리자입니다.");
        }
    }
}