package com.MOOC.OnlineLearningPlatfrom.Repository;

import com.MOOC.OnlineLearningPlatfrom.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 
 */
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
    List<Feedback> findByCourseId(Long courseId);
}