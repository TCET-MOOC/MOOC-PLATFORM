package com.MOOC.OnlineLearningPlatfrom.Repository;

import com.example.demo.entity.CourseContent;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for CourseContent entity
// Provides built-in CRUD operations (save, findAll, findById, delete, etc.)
// No need to write SQL queries manually

public interface CourseContentRepository extends JpaRepository<CourseContent, Long> {
}
