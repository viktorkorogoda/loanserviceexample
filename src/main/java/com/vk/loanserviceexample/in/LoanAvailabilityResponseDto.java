package com.vk.loanserviceexample.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanAvailabilityResponseDto {

    private Integer approvedAmount;
    private String error;
}
