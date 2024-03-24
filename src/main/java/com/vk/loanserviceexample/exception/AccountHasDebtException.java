package com.vk.loanserviceexample.exception;

public class AccountHasDebtException extends RuntimeException {

    public AccountHasDebtException(String message) {
        super(message);
    }
}
