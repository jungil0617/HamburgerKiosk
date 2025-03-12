package main.kiosk;

public enum Option {
    EXIT(0),
    CREATE_ADMIN(1),
    LOGIN_ADMIN(2),
    CREATE_CUSTOMER(3),
    LOGIN_CUSTOMER(4);

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
        throw new IllegalArgumentException();
    }

}