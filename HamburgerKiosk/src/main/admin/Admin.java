package main.admin;

public class Admin {

    private final String adminName;
    private int money;

    public Admin(String name, int money) {
        this.adminName = name;
        this.money = money;
    }

    public String getAdminName() {
        return adminName;
    }

    public int getMoney() {
        return money;
    }

    public void updateMoney(int money) {
        this.money += money;
    }

}