package com.coffeegit.springboot.mybatis.postgres.common.exception;

public class DataNotFoundException extends ServiceException {
    
    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
