package main.io;

public enum InputMessage {

    ROOT("""
            0. 종료
            1. 관리자 생성
            2. 관리자 접속
            3. 회원 생성
            4. 회원 접속"""),
    EXTRA_ORDER("감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)"),
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}