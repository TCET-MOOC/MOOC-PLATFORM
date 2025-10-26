package com.MOOC.OnlineLearningPlatfrom.Service.impl;

import com.MOOC.OnlineLearningPlatfrom.Entity.Discussion;
import com.MOOC.OnlineLearningPlatfrom.Repository.DiscussionRepository;
import com.MOOC.OnlineLearningPlatfrom.Service.DiscussionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionServiceImpl implements DiscussionService {

    private final DiscussionRepository discussionRepository;

    public DiscussionServiceImpl(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    @Override
    public Discussion createDiscussion(Discussion discussion) {
        // You could add validation logic here
        return discussionRepository.save(discussion);
    }

    @Override
    public List<Discussion> getDiscussionByCourseId(Long courseId) {
        return discussionRepository.findByCourseId(courseId);
    }

    @Override
    public Optional<Discussion> getDiscussionById(Long discussionId) {
        return discussionRepository.findById(discussionId);
    }

    @Override
    public void deleteDiscussion(Long discussionId) {
        if (!discussionRepository.existsById(discussionId)) {
            // Or use a custom exception
            throw new RuntimeException("Discussion not found with id: " + discussionId);
        }
        discussionRepository.deleteById(discussionId);
    }
}