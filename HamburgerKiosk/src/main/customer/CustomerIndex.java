package main.customer;

public enum CustomerIndex {

    ID(0),
    MONEY(1);

    private final int index;

    CustomerIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}