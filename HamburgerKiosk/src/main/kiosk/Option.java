package main.kiosk;

import static main.io.InputErrorMessage.INVALID_INPUT;

public enum Option {
    EXIT(0),
    ADMIN_CREATE(1),
    ADMIN_LOGIN(2),
    CUSTOMER_CREATE(3),
    CUSTOMER_LOGIN(4);

    private final int option;

    Option(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public static Option getOption(int num) {
        for (Option option : Option.values()) {
            if (option.getOption() == num) {
                return option;
            }
        }
        throw new IllegalArgumentException(INVALID_INPUT.getMessage());
    }

}