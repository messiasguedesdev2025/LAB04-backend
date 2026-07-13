package com.Lab04Backend.TaskFlow.user.dtos;

import com.Lab04Backend.TaskFlow.user.entity.User;

public record UserResponseDTO(

        String id,
        String name,
        String email,
        String avatar

) {

    public UserResponseDTO(User user) {
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getAvatar()
        );
    }
}
