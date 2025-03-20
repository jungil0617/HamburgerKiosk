package main.io;

public enum InputMessage {

    ROOT("""
            0. 종료
            1. 관리자 생성
            2. 관리자 접속
            3. 회원 생성
            4. 회원 접속"""),
    EXTRA_ORDER("감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)"),
    CREATE_ADMIN("관리자 이름과 잔액을 입력해주세요."),
    LOGIN_ADMIN("로그인할 관리자 이름을 입력해주세요."),
    CREATE_CUSTOMER("회원 번호화 잔액을 입력해주세요"),
    LOGIN_CUSTOMER("로그인할 회원 번호를 입력해주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}