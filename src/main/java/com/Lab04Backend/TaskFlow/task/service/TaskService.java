package com.Lab04Backend.TaskFlow.task.service;

import com.Lab04Backend.TaskFlow.task.dto.TaskRequest;
import com.Lab04Backend.TaskFlow.task.dto.TaskResponse;
import com.Lab04Backend.TaskFlow.task.entity.Task;
import com.Lab04Backend.TaskFlow.task.mapper.TaskMapper;
import com.Lab04Backend.TaskFlow.task.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.time.LocalDateTime;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse create(TaskRequest request) {

        Task task = TaskMapper.toEntity(request);

        task = taskRepository.save(task);

        return TaskMapper.toResponse(task);
    }

    public List<TaskResponse> findAll() {

        return taskRepository.findByDeletedAtIsNull()
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }

    public TaskResponse findById(UUID id) {

        Task task = taskRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada."));

        return TaskMapper.toResponse(task);
    }

    public TaskResponse update(UUID id, TaskRequest request) {

        Task task = taskRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada."));

        TaskMapper.updateEntity(task, request);

        task = taskRepository.save(task);

        return TaskMapper.toResponse(task);
    }

    public void delete(UUID id) {

        Task task = taskRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada."));

        task.setDeletedAt(LocalDateTime.now());

        taskRepository.save(task);
    }
}