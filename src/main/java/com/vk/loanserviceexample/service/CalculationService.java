package com.vk.loanserviceexample.service;

import static com.vk.loanserviceexample.domain.entity.Errors.TOO_LOW_OUTPUT;
import static com.vk.loanserviceexample.loan_config.LoanConstraints.MAX_OUTPUT;
import static com.vk.loanserviceexample.loan_config.LoanConstraints.MIN_OUTPUT;

import com.vk.loanserviceexample.domain.entity.Account;
import com.vk.loanserviceexample.exception.TooLowOutputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculationService {

    private static final double APPROVAL_THRESHOLD = 1.0;

    public Integer calculateApprovedAmount(Account account, Integer requestedAmount, Integer requestedPeriod) {
        Integer creditModifier = account.getLoanStatus().getCreditModifier();
        logCalculatingApprovedAmount(requestedAmount, requestedPeriod, creditModifier);
        double creditScore = calculateCreditScore(requestedAmount, requestedPeriod, creditModifier);

        return decideApprovedAmount(requestedAmount, requestedPeriod, creditModifier, creditScore);
    }

    public Integer calculatePossibleAmount(Integer creditModifier, Integer requestedPeriod) {
        int possibleAmount = creditModifier * requestedPeriod;
        if (possibleAmount < MIN_OUTPUT) {
            throw new TooLowOutputException(TOO_LOW_OUTPUT);
        }
        if (possibleAmount > MAX_OUTPUT) {
            possibleAmount = MAX_OUTPUT;
        }
        return possibleAmount;
    }

    private double calculateCreditScore(Integer requestedAmount, Integer requestedPeriod, Integer creditModifier) {
        return (Double.valueOf(creditModifier) / Double.valueOf(requestedAmount)) * requestedPeriod;
    }

    private void logCalculatingApprovedAmount(Integer requestedAmount, Integer requestedPeriod, Integer creditModifier) {
        log.info("Calculating ApprovedAmount: getCreditModifier: {}, requestedAmount: {}, requestedPeriod: {}", creditModifier, requestedAmount, requestedPeriod);
    }

    private Integer decideApprovedAmount(Integer requestedAmount, Integer requestedPeriod, Integer creditModifier, double creditScore) {
        return creditScore == APPROVAL_THRESHOLD ? requestedAmount : calculatePossibleAmount(creditModifier, requestedPeriod);
    }
}
