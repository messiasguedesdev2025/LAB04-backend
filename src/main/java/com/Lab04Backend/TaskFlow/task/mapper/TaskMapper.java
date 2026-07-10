package com.Lab04Backend.TaskFlow.task.mapper;

import com.Lab04Backend.TaskFlow.task.dto.TaskRequest;
import com.Lab04Backend.TaskFlow.task.dto.TaskResponse;
import com.Lab04Backend.TaskFlow.task.entity.Task;

public class TaskMapper {

    private TaskMapper() {
    }

    public static Task toEntity(TaskRequest request) {
        return Task.builder()
                .status(request.getStatus())
                .priority(request.getPriority())
                .title(request.getTitle())
                .description(request.getDescription())
                .member(request.getMember())
                .time(request.getTime())
                .build();
    }

    public static TaskResponse toResponse(Task task) {
        return TaskResponse.builder()
                .id(task.getId())
                .status(task.getStatus())
                .priority(task.getPriority())
                .title(task.getTitle())
                .description(task.getDescription())
                .member(task.getMember())
                .time(task.getTime())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }

    public static void updateEntity(Task task, TaskRequest request) {
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setMember(request.getMember());
        task.setTime(request.getTime());
    }
}