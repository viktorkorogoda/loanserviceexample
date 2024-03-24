package com.vk.loanserviceexample.exception;

public class TooLowInputException extends RuntimeException implements BadRequestException {

    public TooLowInputException(String message) {
        super(message);
    }
}
