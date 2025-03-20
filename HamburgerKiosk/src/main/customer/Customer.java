package main.customer;

import main.user.User;

public class Customer implements User {

    private final String customerId;
    private int money;

    public Customer(String customerId, int money) {
        this.customerId = customerId;
        this.money = money;
    }

    @Override
    public String getId() {
        return customerId;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void updateMoney(int money) {
        this.money -= money;
    }

}