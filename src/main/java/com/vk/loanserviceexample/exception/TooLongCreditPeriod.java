package com.vk.loanserviceexample.exception;

public class TooLongCreditPeriod extends RuntimeException implements BadRequestException {

    public TooLongCreditPeriod(String message) {
        super(message);
    }

}
