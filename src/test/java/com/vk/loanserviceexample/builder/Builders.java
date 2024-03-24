package com.vk.loanserviceexample.builder;

import com.vk.loanserviceexample.domain.entity.Account;
import com.vk.loanserviceexample.domain.entity.LoanStatus;

public class Builders {

    public static Account buildAccount(String userId, LoanStatus loanStatus) {
        return Account.builder()
                      .userId(userId)
                      .loanStatus(loanStatus)
                      .build();
    }
}
