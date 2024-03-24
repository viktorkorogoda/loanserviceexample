package com.vk.loanserviceexample.validation;

import static com.vk.loanserviceexample.domain.entity.Errors.TOO_HIGH_INPUT;
import static com.vk.loanserviceexample.domain.entity.Errors.TOO_LONG_PERIOD;
import static com.vk.loanserviceexample.domain.entity.Errors.TOO_LOW_INPUT;
import static com.vk.loanserviceexample.domain.entity.Errors.TOO_SHORT_PERIOD;
import static com.vk.loanserviceexample.loan_config.LoanConstraints.MAX_INPUT;
import static com.vk.loanserviceexample.loan_config.LoanConstraints.MAX_PERIOD;
import static com.vk.loanserviceexample.loan_config.LoanConstraints.MIN_INPUT;
import static com.vk.loanserviceexample.loan_config.LoanConstraints.MIN_PERIOD;

import com.vk.loanserviceexample.exception.TooHighInputException;
import com.vk.loanserviceexample.exception.TooLongCreditPeriod;
import com.vk.loanserviceexample.exception.TooLowInputException;
import com.vk.loanserviceexample.exception.TooShortCreditPeriod;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public void validateRequestParams(Integer requestedAmount, Integer requestedPeriod) {
        if (requestedAmount < MIN_INPUT) {
            throw new TooLowInputException(TOO_LOW_INPUT);
        }
        if (requestedAmount > MAX_INPUT) {
            throw new TooHighInputException(TOO_HIGH_INPUT);
        }
        if (requestedPeriod < MIN_PERIOD) {
            throw new TooShortCreditPeriod(TOO_SHORT_PERIOD);
        }
        if (requestedPeriod > MAX_PERIOD) {
            throw new TooLongCreditPeriod(TOO_LONG_PERIOD);
        }
    }
}
