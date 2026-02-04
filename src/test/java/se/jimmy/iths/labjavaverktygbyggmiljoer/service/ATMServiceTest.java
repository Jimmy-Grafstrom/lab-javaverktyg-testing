package se.jimmy.iths.labjavaverktygbyggmiljoer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;
import se.jimmy.iths.labjavaverktygbyggmiljoer.component.AccountComponent;
import se.jimmy.iths.labjavaverktygbyggmiljoer.exceptions.InvalidAmountException;

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
}