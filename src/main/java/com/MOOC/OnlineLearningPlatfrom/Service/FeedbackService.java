package com.MOOC.OnlineLearningPlatfrom.Service;

import com.MOOC.OnlineLearningPlatfrom.Entity.Feedback;
import java.util.List;
import java.util.Optional;

public interface FeedbackService {

    /**
     * Creates and saves a new feedback entry.
     * @param feedback The feedback object to save.
     * @return The saved feedback object with its generated ID.
     */
    Feedback createFeedback(Feedback feedback);

    /**
     * Retrieves all feedback entries for a specific course.
     * @param courseId The ID of the course.
     * @return A list of feedback objects.
     */
    List<Feedback> getFeedbackByCourseId(Long courseId);

    /**
     * Retrieves a single feedback entry by its ID.
     * @param feedbackId The ID of the feedback.
     * @return An Optional containing the feedback if found, or empty if not.
     */
    Optional<Feedback> getFeedbackById(Long feedbackId);

    /**
     * Deletes a feedback entry by its ID.
     * @param feedbackId The ID of the feedback to delete.
     */
    void deleteFeedback(Long feedbackId);
}