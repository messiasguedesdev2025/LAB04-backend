package com.Lab04Backend.TaskFlow.repositories;

import com.Lab04Backend.TaskFlow.models.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BoardRepository extends JpaRepository<Board, UUID> {
    List<Board> findByDeletedAtIsNull();
}
