package main.admin.validator;

public enum AdminErrorMessage {

    INVALID_INPUT("[ERROR] 올바른 형식으로 입력해주세요. (예: 관리자1, 100000)"),
    INVALID_MONEY("[ERROR] 보유 금액은 숫자로 입력해야 합니다."),
    INVALID_NEGATIVE_NUMBER("[ERROR] 음수는 사용할 수 없습니다."),
    DUPLICATE_ADMIN("[ERROR] 이미 존재하는 관리자 이름입니다."),
    ADMIN_NOT_FOUND("[ERROR] 관리자 이름을 찾을 수 없습니다.");

    private final String message;

    AdminErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}