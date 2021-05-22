package com.banking.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Not enough balance in your account")
public class NotEnoughBalanceException extends RuntimeException {

    public NotEnoughBalanceException(String message) {
        super(message);
    }
}