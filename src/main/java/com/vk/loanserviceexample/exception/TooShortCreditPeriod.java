package com.vk.loanserviceexample.exception;

public class TooShortCreditPeriod extends RuntimeException implements BadRequestException {

    public TooShortCreditPeriod(String message) {
        super(message);
    }

}
