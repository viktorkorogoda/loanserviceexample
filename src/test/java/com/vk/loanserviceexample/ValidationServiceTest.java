package com.vk.loanserviceexample;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.vk.loanserviceexample.exception.TooHighInputException;
import com.vk.loanserviceexample.exception.TooLongCreditPeriod;
import com.vk.loanserviceexample.exception.TooLowInputException;
import com.vk.loanserviceexample.exception.TooShortCreditPeriod;
import com.vk.loanserviceexample.validation.ValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ValidationServiceTest {

    @InjectMocks
    private ValidationService validationService;

    @Test
    void givenTooLowInputValue_whenValidate_thenThrowTooLowInputValuerException() {
        Integer requestedAmount = 100;
        Integer requestedPeriod = 12;
        assertThrows(TooLowInputException.class,
                     () -> validationService.validateRequestParams(requestedAmount, requestedPeriod));

    }

    @Test
    void givenTooHighInputValue_whenValidate_thenThrowTooHighInputValueException() {
        Integer requestedAmount = 20000;
        Integer requestedPeriod = 12;
        assertThrows(TooHighInputException.class,
                     () -> validationService.validateRequestParams(requestedAmount, requestedPeriod));
    }

    @Test
    void givenTooShortPeriod_whenValidate_thenThrowTooShortPeriodException() {
        Integer requestedAmount = 5000;
        Integer requestedPeriod = 1;
        assertThrows(TooShortCreditPeriod.class,
                     () -> validationService.validateRequestParams(requestedAmount, requestedPeriod));
    }

    @Test
    void givenTooLongPeriod_whenValidate_thenThrowTooLongPeriodException() {
        Integer requestedAmount = 5000;
        Integer requestedPeriod = 100;
        assertThrows(TooLongCreditPeriod.class,
                     () -> validationService.validateRequestParams(requestedAmount, requestedPeriod));
    }
}
