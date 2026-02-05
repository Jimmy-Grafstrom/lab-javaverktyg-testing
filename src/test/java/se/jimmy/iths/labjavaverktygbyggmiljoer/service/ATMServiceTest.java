package se.jimmy.iths.labjavaverktygbyggmiljoer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;
import se.jimmy.iths.labjavaverktygbyggmiljoer.component.AccountComponent;
import se.jimmy.iths.labjavaverktygbyggmiljoer.exceptions.InsufficientFundsException;
import se.jimmy.iths.labjavaverktygbyggmiljoer.exceptions.InvalidAmountException;
import se.jimmy.iths.labjavaverktygbyggmiljoer.exceptions.MaxWithdrawalExceededException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ATMServiceTest {

    @InjectMocks
    private ATMService atmService;

    @Mock
    private AccountComponent accountComponent;

    @Test
    void depositExecute() {
    atmService.depositExecute(50);
    verify(accountComponent).deposit(50);
    }

    @Test
    void depositBellowZero() {
        int amount = -50;
        assertThrows(InvalidAmountException.class, () -> { atmService.depositExecute(amount);
        });
    }

    @Test
    void withdrawExecuteSuccess() {
//        Arrange
        when(accountComponent.getBalance()).thenReturn(1000);
        int amount = 500;
//        Act
        atmService.withdrawExecute(amount);
//        Assert
        verify(accountComponent).withdraw(amount);
    }

    @Test
    void withdrawExecuteAmountMoreThanBalance_ShouldReturn_InsufficientFundsException() {
        int amount = 50;

        assertThrows(InsufficientFundsException.class, () -> {atmService.withdrawExecute(amount);
        });
    }

    @Test
    void withdrawExecuteAmountBellowZero_ShouldReturn_InvalidAmountException() {
        int amount = -50;

        assertThrows(InvalidAmountException.class, () -> {atmService.withdrawExecute(amount);
        });
    }
    @Test
    void withdrawExecuteAmountAboveMaxWithdraw_ShouldReturn_MaxWithdrawExceededException() {
        int amount = 501;

        assertThrows(MaxWithdrawalExceededException.class, () -> {atmService.withdrawExecute(amount);
        });
    }
}