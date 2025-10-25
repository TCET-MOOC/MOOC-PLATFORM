package com.MOOC.OnlineLearningPlatfrom.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// Module entity -> represents a section/chapter inside a Course
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long moduleId;

    private String title;    // Module title
    private Integer position; // Order inside the course

    // Many modules belong to one course
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false) // Foreign key to Course
    private Course course;

    // One module can have many course contents
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseContent> contents;
}
