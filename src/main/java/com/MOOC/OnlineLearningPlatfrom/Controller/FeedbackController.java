package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- ADDED/CHANGED IMPORTS ---
import com.MOOC.OnlineLearningPlatfrom.Entity.Feedback;
import com.MOOC.OnlineLearningPlatfrom.Service.FeedbackService; // Import the service
// --- END ---

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    /**
     * */
    // --- Inject the Service ---
    private final FeedbackService feedbackService;

    /**
     * */
    // --- Use Constructor Injection for the Service ---
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    /**
     * */
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<Feedback>> getFeedbackByCourseId(@PathVariable Long courseId) {
        // --- Call the service ---
        List<Feedback> feedbacks = feedbackService.getFeedbackByCourseId(courseId);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    /**
     * */
    @PostMapping("/createFeedback")
    public ResponseEntity<Feedback> createFeedbackForCourse(@Valid @RequestBody Feedback feedback) {
        // --- Call the service ---
        Feedback newFeedback = feedbackService.createFeedback(feedback);
        return new ResponseEntity<>(newFeedback, HttpStatus.CREATED);
    }

    // --- OPTIONAL: Good to add GetByID and Delete endpoints ---

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        try {
            feedbackService.deleteFeedback(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}