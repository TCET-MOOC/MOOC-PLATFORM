package com.MOOC.OnlineLearningPlatfrom.Repository;

import com.MOOC.OnlineLearningPlatfrom.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for Course entity
// Inherits common CRUD methods (save, findAll, findById, delete, etc.)
// Spring Data JPA will generate the implementation at runtime

public interface CourseRepository extends JpaRepository<Course, Long> {
}
