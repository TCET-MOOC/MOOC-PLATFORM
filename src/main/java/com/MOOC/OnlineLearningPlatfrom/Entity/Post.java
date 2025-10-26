package com.MOOC.OnlineLearningPlatfrom.Entity;

// --- ADDED IMPORTS ---
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// --- END ---
import lombok.*;

import java.time.LocalDateTime;

/**
 *
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {
    /**
     *
     */
    // --- ADDED ANNOTATIONS ---
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    /**
     *
     */
    private Long userId;

    /**
     *
     */
    private Long threadId;

    /**
     *
     */
    private String body;

    /**
     *
     */
    private LocalDateTime createdAt;
}