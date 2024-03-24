package com.vk.loanserviceexample.exception;


public class TooHighOutputException extends RuntimeException implements BadRequestException {

    public TooHighOutputException(String message) {
        super(message);
    }

}
