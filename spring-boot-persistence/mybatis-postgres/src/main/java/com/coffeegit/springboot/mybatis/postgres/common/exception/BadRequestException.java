package com.coffeegit.springboot.mybatis.postgres.common.exception;

public class BadRequestException extends ServiceException {
    
    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
