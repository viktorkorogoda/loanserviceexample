package com.vk.loanserviceexample;

import static com.vk.loanserviceexample.builder.Builders.buildAccount;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.lenient;

import com.vk.loanserviceexample.domain.entity.Account;
import com.vk.loanserviceexample.domain.entity.LoanStatus;
import com.vk.loanserviceexample.exception.AccountHasDebtException;
import com.vk.loanserviceexample.persistence.LoanRepository;
import com.vk.loanserviceexample.persistence.dao.AccountDao;
import com.vk.loanserviceexample.persistence.mapper.PersistenceAccountMapper;
import com.vk.loanserviceexample.service.LoanService;
import com.vk.loanserviceexample.validation.ValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LoanServiceTest {

    @Mock
    private ValidationService validationService;
    @Mock
    private LoanRepository loanRepository;
    @Mock
    private PersistenceAccountMapper persistenceAccountMapper;
    @InjectMocks
    private LoanService loanService;

    @Test
    void givenAccountWithDebt_whenCalculatingLoanAvailability_thenThrowException() {
        doNothing().when(validationService).validateRequestParams(any(), any());

        AccountDao accountDaoWithDebt = new AccountDao();
        accountDaoWithDebt.setLoanStatus("DEBT");
        accountDaoWithDebt.setId(1);
        accountDaoWithDebt.setUserId("123456");

        Account accountWithDebt = buildAccount("123", LoanStatus.DEBT);

        doReturn(accountDaoWithDebt).when(loanRepository).findByUserId(any());
        doReturn(accountWithDebt).when(persistenceAccountMapper).toAccount(accountDaoWithDebt);
        assertThrows(AccountHasDebtException.class,
                     ()->loanService.calculateLoanAvailability("any", 1, 1));
    }

}
