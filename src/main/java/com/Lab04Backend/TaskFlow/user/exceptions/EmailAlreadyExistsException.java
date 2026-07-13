package com.Lab04Backend.TaskFlow.user.exceptions;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends BusinessException {

    public EmailAlreadyExistsException(String email) {
        super(
                "The email '" + email + "' is already in use.",
                HttpStatus.CONFLICT
        );
    }
}