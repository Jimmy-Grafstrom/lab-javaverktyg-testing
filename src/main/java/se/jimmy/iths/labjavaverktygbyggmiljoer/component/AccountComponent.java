package se.jimmy.iths.labjavaverktygbyggmiljoer.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Setter
@Getter
@Component
public class AccountComponent {
    private int balance = 0;

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int withdraw(int change) {
        return balance -= change;
    }

    public int printBalance() {
        return balance;
    }
}
