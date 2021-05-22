package com.banking.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Account number not found")
public class InvalidAccountNumberException extends RuntimeException {

    public InvalidAccountNumberException(String message) {
        super(message);
    }

}