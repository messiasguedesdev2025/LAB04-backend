package com.Lab04Backend.TaskFlow.task.dto;

import com.Lab04Backend.TaskFlow.task.enums.BoardStatus;
import com.Lab04Backend.TaskFlow.task.enums.Priority;
import lombok.*;

        import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskResponse {

    private UUID id;

    private BoardStatus status;

    private Priority priority;

    private String title;

    private String description;

    private Long member;

    private String time;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}