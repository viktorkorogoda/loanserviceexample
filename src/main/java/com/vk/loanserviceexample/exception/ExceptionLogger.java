package com.vk.loanserviceexample.exception;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLogger {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionLogger.class);

    @AfterThrowing(pointcut = "within(com.vk.loanserviceexample.service..*)", throwing = "e")
    public void logExceptionMessage(Throwable e) {
        logger.info(e.getMessage());
    }

}