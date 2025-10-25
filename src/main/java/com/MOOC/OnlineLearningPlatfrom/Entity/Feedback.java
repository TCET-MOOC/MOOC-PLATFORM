package com.MOOC.OnlineLearningPlatfrom.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 
 */
@Entity
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "feedback")
public class Feedback {

    /**
     * Unique Identifier for feed (Primary Key)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

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
    @Column(nullable = false, length = 500) 
    @Size(min = 20, max = 500, message = "Feedback message must be between 20 to 500 characters.")
    private String message;

    /**
     * 
     */
    @Column(nullable = false, updatable = false) 
    private LocalDateTime createdAt = LocalDateTime.now();

    
}
