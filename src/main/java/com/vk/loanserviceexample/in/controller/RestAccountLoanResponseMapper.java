package com.vk.loanserviceexample.in.controller;

import com.vk.loanserviceexample.in.LoanAvailabilityResponseDto;
import com.vk.loanserviceexample.in.LoanAvailabilityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface RestAccountLoanResponseMapper {


    @Mapping(target = "approvedAmount", source = "approvedAmount")
    @Mapping(target = "error", source = "error")
    LoanAvailabilityResponseDto toLoanAvailabilityResponseDto(LoanAvailabilityResponse account);
}