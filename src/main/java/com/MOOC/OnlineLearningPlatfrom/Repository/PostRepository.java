package com.MOOC.OnlineLearningPlatfrom.Repository;

import com.example.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 
 */
public interface PostRepository extends JpaRepository<Post,Long>{
    List<Post> findByCourseId(Long courseId);
    List<Post> findByUserId(Long userId);
}