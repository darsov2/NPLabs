package lab1.lab1_2;

import java.util.Random;

class Account {
    String name;
    String balance;
    long id;

    public Account(String name, String balance) {
        this.name = name;
        this.balance = balance;

        Random random = new Random();
        id = random.nextLong();
    }

    public Account(Account acc)
    {
        this.name = acc.name;
        this.balance = acc.balance;
        this.id = acc.id;
    }

    public String getName() {
        return name;
    }

    public String getBalance() {
        return balance;
    }

    public long getId() {
        return id;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Name:" + name + '\n' +
                "Balance:" + balance + '\n';
    }
}