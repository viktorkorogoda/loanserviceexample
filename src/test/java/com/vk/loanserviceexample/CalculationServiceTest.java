package com.vk.loanserviceexample;


import static com.vk.loanserviceexample.builder.Builders.buildAccount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.vk.loanserviceexample.domain.entity.Account;
import com.vk.loanserviceexample.domain.entity.LoanStatus;
import com.vk.loanserviceexample.exception.TooLowOutputException;
import com.vk.loanserviceexample.service.CalculationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculationServiceTest {

    @InjectMocks
    private CalculationService calculationService;

    @Test
    void givenAccountWithSegment1WithValidRequest_whenCalculateApprovedAmount_thenReturnValidResult() {
        Account account = buildAccount("12345", LoanStatus.SEGMENT_1);
        Integer requestedAmount = 2500;
        Integer requestedPeriod = 60;

        Integer expectedApprovedAmount = 6000;

        Integer actualApprovedAmount = calculationService.calculateApprovedAmount(account, requestedAmount, requestedPeriod);

        assertThat(actualApprovedAmount).isEqualTo(expectedApprovedAmount);
    }

    @Test
    void givenAccountWithSegment1WithInvalidLowRequestDataWithHardcodedAdditionalData_whenCalculateApprovedAmount_thenThrowException() {
        Account account = buildAccount("49002010976", LoanStatus.SEGMENT_1);
        Integer requestedAmount = 2500;
        Integer requestedPeriod = 12;
        assertThrows(TooLowOutputException.class,
                     () -> calculationService.calculateApprovedAmount(account, requestedAmount, requestedPeriod));
    }

}
