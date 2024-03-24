package com.vk.loanserviceexample.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String TIMESTAMP = "timestamp";
    public static final String STATUS = "status";
    public static final String ERROR = "error";
    public static final String MESSAGE = "message";

    @ExceptionHandler({
            AccountHasDebtException.class,
            AccountNotFoundException.class,
            TooHighInputException.class,
            TooHighOutputException.class,
            TooLongCreditPeriod.class,
            TooLowInputException.class,
            TooLowOutputException.class,
            TooShortCreditPeriod.class
    })
    public ResponseEntity<Object> handleCustomException(RuntimeException exception) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if (exception instanceof AccountNotFoundException) {
            status = HttpStatus.NOT_FOUND;
        } else if (exception instanceof BadRequestException) {
            status = HttpStatus.BAD_REQUEST;
        }

        Map<String, Object> body = new HashMap<>();
        body.put(TIMESTAMP, LocalDateTime.now());
        body.put(STATUS, status.value());
        body.put(ERROR, status.getReasonPhrase());
        body.put(MESSAGE, exception.getMessage());

        return new ResponseEntity<>(body, status);
    }
}
