package com.Lab04Backend.TaskFlow.dtos;

import com.Lab04Backend.TaskFlow.models.Board;
import com.Lab04Backend.TaskFlow.models.BoardStatus;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public record BoardResponse(
    UUID id,
    BoardStatus status,
    List<UUID> userIds,
    List<UUID> adminIds,
    List<UUID> taskIds,
    Instant createdAt,
    Instant updatedAt,
    Instant deletedAt
) {
    public static BoardResponse fromEntity(Board board) {
        return new BoardResponse(
            board.getId(),
            board.getStatus(),
            board.getUserIds() != null ? board.getUserIds() : Collections.emptyList(),
            board.getAdminIds() != null ? board.getAdminIds() : Collections.emptyList(),
            Collections.emptyList(),
            board.getCreatedAt(),
            board.getUpdatedAt(),
            board.getDeletedAt()
        );
    }
}
