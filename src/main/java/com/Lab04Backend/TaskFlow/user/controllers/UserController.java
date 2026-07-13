package com.Lab04Backend.TaskFlow.user.controllers;

import com.Lab04Backend.TaskFlow.user.dtos.RegisterUserDTO;
import com.Lab04Backend.TaskFlow.user.dtos.UserResponseDTO;
import com.Lab04Backend.TaskFlow.user.entity.User;
import com.Lab04Backend.TaskFlow.user.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(
            @Valid @RequestBody RegisterUserDTO dto
    ) {

        User user = service.register(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new UserResponseDTO(user));

    }

}
