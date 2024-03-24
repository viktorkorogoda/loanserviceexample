package com.vk.loanserviceexample.exception;

public class TooLowOutputException extends RuntimeException implements BadRequestException {

    public TooLowOutputException(String message) {
        super(message);
    }
}
