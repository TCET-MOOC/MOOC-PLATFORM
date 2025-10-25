package com.MOOC.OnlineLearningPlatfrom.Repository;

import com.example.demo.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for Module entity
// Extends JpaRepository to provide CRUD operations (save, findAll, findById, delete, etc.)
// No need to write implementation; Spring Data JPA auto-generates it at runtime

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
