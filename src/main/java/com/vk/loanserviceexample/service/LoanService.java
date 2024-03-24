package com.vk.loanserviceexample.service;

import static com.vk.loanserviceexample.domain.entity.Errors.HAS_DEBT;
import static com.vk.loanserviceexample.domain.entity.Errors.NO_ACCOUNT;
import static java.util.Objects.isNull;

import com.vk.loanserviceexample.domain.entity.Account;
import com.vk.loanserviceexample.exception.AccountHasDebtException;
import com.vk.loanserviceexample.exception.AccountNotFoundException;
import com.vk.loanserviceexample.in.LoanAvailabilityResponse;
import com.vk.loanserviceexample.persistence.LoanRepository;
import com.vk.loanserviceexample.persistence.dao.AccountDao;
import com.vk.loanserviceexample.persistence.mapper.PersistenceAccountMapper;
import com.vk.loanserviceexample.validation.ValidationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoanService {

    private final PersistenceAccountMapper persistenceAccountMapper;
    private final LoanRepository loanRepository;
    private final ValidationService validationService;
    private final CalculationService calculationService;

    @Autowired
    public LoanService(PersistenceAccountMapper persistenceAccountMapper, LoanRepository loanRepository, ValidationService validationService, CalculationService calculationService) {
        this.persistenceAccountMapper = persistenceAccountMapper;
        this.loanRepository = loanRepository;
        this.validationService = validationService;
        this.calculationService = calculationService;
    }

    public LoanAvailabilityResponse calculateLoanAvailability(String userId, Integer requestedAmount, Integer requestedPeriod) {
        validationService.validateRequestParams(requestedAmount, requestedPeriod);

        Account account = findAccountByUserId(userId);
        if (account.hasDebt()) {
            throw new AccountHasDebtException(HAS_DEBT);
        }

        logCalculationRequest(userId, requestedAmount, requestedPeriod);
        return new LoanAvailabilityResponse(calculationService.calculateApprovedAmount(account, requestedAmount, requestedPeriod));
    }

    public Account findAccountByUserId(String userId) {
        AccountDao accountDao = loanRepository.findByUserId(userId);
        if (isNull(accountDao)) {
            throw new AccountNotFoundException(NO_ACCOUNT);
        }
        return persistenceAccountMapper.toAccount(accountDao);
    }

    private void logCalculationRequest(String userId, Integer requestedAmount, Integer requestedPeriod) {
        log.info("Calculating loan availability for: userId: {}, requestedAmount: {}, requestedPeriod: {}", userId, requestedAmount, requestedPeriod);
    }

}
