package com.MOOC.OnlineLearningPlatfrom.Controller;

import com.example.demo.entity.Discussion;
import com.example.demo.repository.DiscussionRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 */
@RestController
@RequestMapping("/discussions")
public class DiscussionController {
    
    /**
     * 
     */
    private final DiscussionRepository discussionRepository;

    /**
     * 
     */
    public DiscussionController(DiscussionRepository discussionRepository) {
        this.discussionRepository = discussionRepository;
    }

    /**
     * Fetches all discussions related to a specific course.
     */
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<Discussion>> getDiscussionByCourseId(@PathVariable Long courseId) {
        List<Discussion> discussions = discussionRepository.findByCourseId(courseId);
        return new ResponseEntity<>(discussions, HttpStatus.OK);
    }

    /**
     * Creates a new discussion.
     */
    @PostMapping("/createDiscussion")
    public ResponseEntity<Discussion> createDiscussion(@Valid @RequestBody  Discussion discussion) {
        Discussion newDiscussion = discussionRepository.save(discussion);
        return new ResponseEntity<>(newDiscussion, HttpStatus.CREATED);
    }

}
