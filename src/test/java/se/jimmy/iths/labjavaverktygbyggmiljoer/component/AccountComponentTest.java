package se.jimmy.iths.labjavaverktygbyggmiljoer.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.jimmy.iths.labjavaverktygbyggmiljoer.service.ATMService;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountComponentTest {

    private ATMService atmService;
    private AccountComponent accountComponent;
    @BeforeEach
    void setUp() {
        accountComponent = new AccountComponent();

    }

    @Test
    void balance_IsZeroInitially() {
        assertEquals(0, accountComponent.getBalance());
    }

    @Test
    void deposit_ShouldIncreaseBalance() {
//      Act
        accountComponent.deposit(50);
        int result = accountComponent.getBalance();
//      Assert
        assertEquals(50, result);
    }

    @Test
    void withdraw_ShouldDecreaseBalance() {
        accountComponent.setBalance(100);
        accountComponent.withdraw(50);
        int result = accountComponent.getBalance();

        assertEquals(50, result);
    }

    @Test
    void printBalance_ShouldReturnCorrectBalance() {
        accountComponent.setBalance(50);
        int result = accountComponent.printBalance();
        assertEquals(50, result);
    }
}