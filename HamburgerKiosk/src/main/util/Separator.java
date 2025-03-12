package main.util;

public enum Separator {

    COMMA(","),
    BLANK(" "),
    OPEN_SQUARE_BRACKETS("["),
    CLOSE_SQUARE_BRACKETS("]"),
    HYPHEN("\\-"),
    QUOTES("^\"|\"$");

    private final String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }

}