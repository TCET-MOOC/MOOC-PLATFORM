package com.MOOC.OnlineLearningPlatfrom.Service;

import com.MOOC.OnlineLearningPlatfrom.Entity.CourseContent;
import java.util.List;
import java.util.Optional;

public interface CourseContentService {

    /**
     * Retrieves all course content entries.
     * @return A list of all course content.
     */
    List<CourseContent> getAllContents();

    /**
     * Retrieves a single course content by its ID.
     * @param id The ID of the content.
     * @return An Optional containing the content if found.
     */
    Optional<CourseContent> getContentById(Long id);

    /**
     * Creates and saves a new course content.
     * @param content The content object to save.
     * @return The saved content object.
     */
    CourseContent createContent(CourseContent content);

    /**
     * Updates an existing course content.
     * @param id The ID of the content to update.
     * @param contentDetails The object containing the new details.
     * @return An Optional containing the updated content if found.
     */
    Optional<CourseContent> updateContent(Long id, CourseContent contentDetails);

    /**
     * Deletes a course content by its ID.
     * @param id The ID of the content to delete.
     */
    void deleteContent(Long id);
}