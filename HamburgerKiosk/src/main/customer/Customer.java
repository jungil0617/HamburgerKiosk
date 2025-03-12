package main.customer;

public class Customer {

    private final int customerId;
    private int money;

    public Customer(int customerId, int money) {
        this.customerId = customerId;
        this.money = money;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getMoney() {
        return money;
    }

    public void updateMoney(int money) {
        this.money -= money;
    }

}