package com.MOOC.OnlineLearningPlatfrom.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

/**
 * 
 */
@Entity
@Getter
@Setter                    
@NoArgsConstructor          
@AllArgsConstructor     
@Table(name = "discussion")                        
public class Discussion {

    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discussionId;

    /**
     * 
     */
    @Column(nullable = false)
    private Long userId;

    /**
     * 
     */
    @Column(nullable = false)
    private Long courseId;

    /**
     * 
     */
    @Column(nullable = false, length = 1000)
    @Size(min = 50, max = 1000, message = "Content of the discussion must be between 50 to 1000 characters")
    private String content;

    /**
     * 
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
