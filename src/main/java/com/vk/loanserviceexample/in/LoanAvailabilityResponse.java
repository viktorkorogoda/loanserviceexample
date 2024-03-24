package com.vk.loanserviceexample.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanAvailabilityResponse {

    private Integer approvedAmount;
    private String error;

    public LoanAvailabilityResponse(String error) {
        this.error = error;
    }

    public LoanAvailabilityResponse(Integer approvedAmount) {
        this.approvedAmount = approvedAmount;
    }
}
