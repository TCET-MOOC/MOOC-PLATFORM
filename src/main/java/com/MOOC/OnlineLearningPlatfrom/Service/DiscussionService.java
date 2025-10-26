package com.MOOC.OnlineLearningPlatfrom.Service;

import com.MOOC.OnlineLearningPlatfrom.Entity.Discussion;
import java.util.List;
import java.util.Optional;

public interface DiscussionService {

    /**
     * Creates and saves a new discussion.
     * @param discussion The discussion object to save.
     * @return The saved discussion object with its generated ID.
     */
    Discussion createDiscussion(Discussion discussion);

    /**
     * Retrieves all discussions for a specific course.
     * @param courseId The ID of the course.
     * @return A list of discussion objects.
     */
    List<Discussion> getDiscussionByCourseId(Long courseId);

    /**
     * Retrieves a single discussion by its ID.
     * @param discussionId The ID of the discussion.
     * @return An Optional containing the discussion if found, or empty if not.
     */
    Optional<Discussion> getDiscussionById(Long discussionId);

    /**
     * Deletes a discussion by its ID.
     * @param discussionId The ID of the discussion to delete.
     */
    void deleteDiscussion(Long discussionId);
}