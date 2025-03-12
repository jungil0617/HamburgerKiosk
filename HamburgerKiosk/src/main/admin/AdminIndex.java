package main.admin;

public enum AdminIndex {

    NAME(0),
    MONEY(1);

    private final int index;

    AdminIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}