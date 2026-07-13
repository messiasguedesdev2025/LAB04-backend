package com.Lab04Backend.TaskFlow.user.exceptions;

import org.hibernate.validator.constraints.UUID;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(UUID id) {
        super(
                "User " + id + " is not found.",
                HttpStatus.NOT_FOUND
        );
    }
}