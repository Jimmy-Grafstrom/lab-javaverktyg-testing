package se.jimmy.iths.labjavaverktygbyggmiljoer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.jimmy.iths.labjavaverktygbyggmiljoer.component.AccountComponent;
import se.jimmy.iths.labjavaverktygbyggmiljoer.exceptions.InvalidAmountException;

@Service
@RequiredArgsConstructor
public class ATMService {
    private final AccountComponent accountComponent;

    public void depositExecute(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Forbidden value for transaction");
        }
        accountComponent.deposit(amount);
    }

    public void withdrawExecute (int amount) {
//        if (amount)
    }
    public int getBalance() {
        return accountComponent.getBalance();
    }
}
