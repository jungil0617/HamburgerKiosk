package main.customer.validator;

public enum CustomerErrorMessage {

    INVALID_INPUT("[ERROR] 올바른 형식으로 입력해주세요. (예: 1, 100000)"),
    INVALID_NUMBER("[ERROR] 숫자로 입력해야 합니다."),
    INVALID_NEGATIVE_NUMBER("[ERROR] 음수는 사용할 수 없습니다."),
    DUPLICATE_CUSTOMER("[ERROR] 이미 존재하는 고유 번호입니다."),
    CUSTOMER_NOT_FOUND("[ERROR] 번호을 찾을 수 없습니다.");


    private final String message;

    CustomerErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}