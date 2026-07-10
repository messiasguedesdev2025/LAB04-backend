package com.Lab04Backend.TaskFlow.task.repository;

import com.Lab04Backend.TaskFlow.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByDeletedAtIsNull();
    Optional<Task> findByIdAndDeletedAtIsNull(UUID id);
}