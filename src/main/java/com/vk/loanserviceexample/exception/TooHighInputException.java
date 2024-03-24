package com.vk.loanserviceexample.exception;


public class TooHighInputException extends RuntimeException implements BadRequestException {

    public TooHighInputException(String message) {
        super(message);
    }

}
