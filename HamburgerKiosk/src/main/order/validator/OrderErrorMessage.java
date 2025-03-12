package main.order.validator;

public enum OrderErrorMessage {

    INVALID_FORMAT("[ERROR] 올바르지 않은 형식으로 입력되었습니다."),
    PRODUCT_NOT_FOUND("[ERROR] 존재하지 않는 상품입니다."),
    INVALID_QUANTITY("[ERROR] 재고 수량을 초과하여 구매할 수 없습니다.");

    private final String message;

    OrderErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}