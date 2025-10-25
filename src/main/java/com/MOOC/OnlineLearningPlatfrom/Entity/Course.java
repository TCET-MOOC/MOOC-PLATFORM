package com.MOOC.OnlineLearningPlatfrom.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

// Course entity -> represents a course in the system
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long courseId;

    private String title; // Course title

    @Column(length = 2000) // Longer description allowed
    private String description;

    private Long departmentId; // Linked department
    private Long creatorId;    // Creator (teacher/admin) ID

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now(); // Auto set creation time

    // One Course -> Many Modules
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Module> modules;
}
