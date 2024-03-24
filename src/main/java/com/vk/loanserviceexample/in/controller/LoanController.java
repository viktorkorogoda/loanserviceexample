package com.vk.loanserviceexample.in.controller;

import com.vk.loanserviceexample.in.LoanAvailabilityResponseDto;
import com.vk.loanserviceexample.in.LoanAvailabilityResponse;
import com.vk.loanserviceexample.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private final LoanService loanService;
    private final RestAccountLoanResponseMapper mapper;

    @Autowired
    public LoanController(LoanService loanService, RestAccountLoanResponseMapper mapper) {
        this.loanService = loanService;
        this.mapper = mapper;
    }

    @GetMapping("/calculateLoan/{userId}/{requestedAmount}/{requestedPeriod}")
    public ResponseEntity<LoanAvailabilityResponseDto> calculateLoanAvailability(@PathVariable @NonNull String userId,
                                                                                 @PathVariable @NonNull Integer requestedAmount,
                                                                                 @PathVariable @NonNull Integer requestedPeriod) {
        LoanAvailabilityResponse loanAvailabilityResponse = loanService.calculateLoanAvailability(userId, requestedAmount, requestedPeriod);
        return ResponseEntity.ok(mapper.toLoanAvailabilityResponseDto(loanAvailabilityResponse));
    }
}
