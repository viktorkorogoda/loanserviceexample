package com.vk.loanserviceexample.domain.entity;

import static com.vk.loanserviceexample.domain.entity.LoanStatus.DEBT;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private Integer id;
    private String userId;
    private LoanStatus loanStatus;

    public boolean hasDebt() {
        return DEBT == loanStatus;
    }
}
