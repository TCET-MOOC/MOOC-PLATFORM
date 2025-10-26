package com.MOOC.OnlineLearningPlatfrom.Service.impl;

import com.MOOC.OnlineLearningPlatfrom.Entity.CourseContent;
import com.MOOC.OnlineLearningPlatfrom.Repository.CourseContentRepository;
import com.MOOC.OnlineLearningPlatfrom.Service.CourseContentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseContentServiceImpl implements CourseContentService {

    private final CourseContentRepository contentRepository;

    public CourseContentServiceImpl(CourseContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public List<CourseContent> getAllContents() {
        return contentRepository.findAll();
    }

    @Override
    public Optional<CourseContent> getContentById(Long id) {
        return contentRepository.findById(id);
    }

    @Override
    public CourseContent createContent(CourseContent content) {
        // Business logic, e.g., validating file path, can go here
        return contentRepository.save(content);
    }

    @Override
    public Optional<CourseContent> updateContent(Long id, CourseContent contentDetails) {
        return contentRepository.findById(id).map(content -> {
            // Update fields
            content.setTitle(contentDetails.getTitle());
            content.setContentType(contentDetails.getContentType());
            content.setFilePath(contentDetails.getFilePath());
            content.setDurationSeconds(contentDetails.getDurationSeconds());
            content.setPosition(contentDetails.getPosition());
            // Note: We don't update the 'module' here via this method
            // That's a more complex operation.

            return contentRepository.save(content); // Save updated content
        });
    }

    @Override
    public void deleteContent(Long id) {
        if (!contentRepository.existsById(id)) {
            throw new RuntimeException("CourseContent not found with id: " + id);
        }
        contentRepository.deleteById(id);
    }
}