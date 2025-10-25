package com.MOOC.OnlineLearningPlatfrom.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// CourseContent entity -> represents learning materials (video, pdf, quiz, etc.)
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CourseContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long contentId;

    private String contentType; // e.g., video, pdf, quiz
    private String title;       // Content title
    private String filePath;    // File location (URL or path)
    private Integer durationSeconds; // Duration (for video/audio)
    private Integer position;        // Order inside module

    @Builder.Default
    private LocalDateTime uploadedAt = LocalDateTime.now(); // Auto set upload time

    // Many contents belong to one module
    @ManyToOne
    @JoinColumn(name = "module_id", nullable = false) // Foreign key to Module
    private Module module;
}
