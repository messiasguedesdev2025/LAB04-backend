package com.Lab04Backend.TaskFlow.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "boards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BoardStatus status;

    @ElementCollection
    @CollectionTable(
        name = "board_users",
        joinColumns = @JoinColumn(name = "board_id")
    )
    @Column(name = "user_id")
    @Builder.Default
    private List<UUID> userIds = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
        name = "board_admins",
        joinColumns = @JoinColumn(name = "board_id")
    )
    @Column(name = "user_id")
    @Builder.Default
    private List<UUID> adminIds = new ArrayList<>();

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedAt;

    private Instant deletedAt;
}
