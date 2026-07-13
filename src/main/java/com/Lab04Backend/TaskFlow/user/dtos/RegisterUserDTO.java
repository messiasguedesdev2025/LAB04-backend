package com.Lab04Backend.TaskFlow.user.dtos;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RegisterUserDTO(

        @NotBlank
        String name,

        @Email
        @NotBlank
        String email,

        @NotBlank
        String password,

        String avatar,

        LocalDate birthday

) {
}
