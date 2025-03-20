package main.io;

public enum OutputMessage {

    DISPLAY_INTRO("""
        =================================
        안녕하세요. %s님 햄버거 가게 입니다.
        현재 접속된 관리자는 %s 입니다.
        """);

    private final String message;

    OutputMessage(String messages) {
        this.message = messages;
    }

    public String getMessage() {
        return message;
    }
}