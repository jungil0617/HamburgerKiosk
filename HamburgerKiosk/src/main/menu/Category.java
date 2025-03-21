package main.menu;

import static main.io.InputErrorMessage.INVALID_OPTION;

public enum Category {

    BURGER("햄버거"),
    SET("세트"),
    SIDE("사이드"),
    DRINK("음료수");

    private final String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public static Category fromString(String input) {
        for (Category category : Category.values()) {
            if (category.getCategory().equals(input.trim())) {
                return category;
            }
        }
        throw new IllegalArgumentException(INVALID_OPTION.getMessage());
    }

}