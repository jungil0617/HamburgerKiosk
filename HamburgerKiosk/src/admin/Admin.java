package admin;

public class Admin {

    private final String name;
    private int money;

    public Admin(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void updateMoney(int money) {
        this.money = money;
    }
}