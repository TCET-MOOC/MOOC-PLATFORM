package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- ADDED/CHANGED IMPORTS ---
import com.MOOC.OnlineLearningPlatfrom.Entity.Discussion;
import com.MOOC.OnlineLearningPlatfrom.Service.DiscussionService; // Import the service
// --- END ---

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
    // --- Inject the Service ---
    private final DiscussionService discussionService;

    /**
     *
     */
    // --- Use Constructor Injection for the Service ---
    public DiscussionController(DiscussionService discussionService) {
        this.discussionService = discussionService;
    }

    /**
     * Fetches all discussions related to a specific course.
     */
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<Discussion>> getDiscussionByCourseId(@PathVariable Long courseId) {
        // --- Call the service ---
        List<Discussion> discussions = discussionService.getDiscussionByCourseId(courseId);
        return new ResponseEntity<>(discussions, HttpStatus.OK);
    }

    /**
     * Creates a new discussion.
     */
    @PostMapping("/createDiscussion")
    public ResponseEntity<Discussion> createDiscussion(@Valid @RequestBody Discussion discussion) {
        // --- Call the service ---
        Discussion newDiscussion = discussionService.createDiscussion(discussion);
        return new ResponseEntity<>(newDiscussion, HttpStatus.CREATED);
    }

    // --- OPTIONAL: Good to add GetByID and Delete endpoints ---

    @GetMapping("/{id}")
    public ResponseEntity<Discussion> getDiscussionById(@PathVariable Long id) {
        return discussionService.getDiscussionById(id)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscussion(@PathVariable Long id) {
        try {
            discussionService.deleteDiscussion(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}