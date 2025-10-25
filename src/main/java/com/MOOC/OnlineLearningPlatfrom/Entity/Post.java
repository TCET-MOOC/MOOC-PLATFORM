package com.MOOC.OnlineLearningPlatfrom.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
public class Post{
    /**
     * 
     */
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