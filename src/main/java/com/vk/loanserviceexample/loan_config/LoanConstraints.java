package com.vk.loanserviceexample.loan_config;

import org.springframework.stereotype.Component;

@Component
public class LoanConstraints {

    public static final Integer MIN_INPUT = 2000;
    public static final Integer MAX_INPUT = 10000;
    public static final Integer MIN_OUTPUT = 2000;
    public static final Integer MAX_OUTPUT = 10000;
    public static final Integer MIN_PERIOD = 12;
    public static final Integer MAX_PERIOD = 60;

    private LoanConstraints(){

    }
}
