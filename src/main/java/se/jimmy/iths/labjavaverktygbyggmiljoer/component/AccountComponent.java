package se.jimmy.iths.labjavaverktygbyggmiljoer.component;

import org.springframework.stereotype.Component;

@Component
public class AccountComponent {
    private int balance = 0;

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int withdraw(int balance, int change) {
        return balance -= change;
    }



    public int getBalance() {
        return balance;
    }
}
