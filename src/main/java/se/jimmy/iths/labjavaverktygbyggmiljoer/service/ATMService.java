package se.jimmy.iths.labjavaverktygbyggmiljoer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se.jimmy.iths.labjavaverktygbyggmiljoer.component.AccountComponent;
import se.jimmy.iths.labjavaverktygbyggmiljoer.exceptions.InsufficientFundsException;
import se.jimmy.iths.labjavaverktygbyggmiljoer.exceptions.InvalidAmountException;
import se.jimmy.iths.labjavaverktygbyggmiljoer.exceptions.MaxWithdrawalExceededException;

@Service
@RequiredArgsConstructor
public class ATMService {
    private final AccountComponent accountComponent;
    private final int maxWithdraw = 500;

    public void depositExecute(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Forbidden value for transaction");
        }
        accountComponent.deposit(amount);
    }

    public void withdrawExecute (int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Forbidden value for transaction");
        }
        if (amount > maxWithdraw) {
            throw new MaxWithdrawalExceededException("Amount exceeds max amount");
        }
        if (amount > getBalance()) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        accountComponent.withdraw(amount);
    }

    public int getBalance() {
        return accountComponent.getBalance();
    }
}
