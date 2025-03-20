package main.admin;

import main.user.User;

public class Admin implements User {

    private final String adminId;
    private int money;

    public Admin(String name, int money) {
        this.adminId = name;
        this.money = money;
    }

    @Override
    public String getId() {
        return adminId;
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void updateMoney(int money) {
        this.money += money;
    }

}