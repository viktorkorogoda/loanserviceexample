package com.vk.loanserviceexample.domain.entity;

public class Errors {

    public static final String NO_ACCOUNT = "No account found with provided data";
    public static final String HAS_DEBT = "User has debt";
    public static final String TOO_LOW_INPUT = "Too low input value";
    public static final String TOO_LOW_OUTPUT = "Too low output value";
    public static final String TOO_HIGH_INPUT = "Too high input value";
    public static final String TOO_HIGH_OUTPUT = "Too high output value";
    public static final String TOO_SHORT_PERIOD = "Too short period";
    public static final String TOO_LONG_PERIOD = "Too long period";
    public static final String INCORRECT_LOAN_REQUEST_AMOUNT = "Incorrect loan request amount";

    private Errors() {

    }
}
