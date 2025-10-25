package com.MOOC.OnlineLearningPlatfrom.Controller;

import com.example.demo.entity.Feedback;
import com.example.demo.repository.FeedbackRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    /**
     * 
     */
    private final FeedbackRepository feedbackRepository;

    /**
     * 
     */
    public FeedbackController(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    /**
     * 
     */
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<List<Feedback>> getFeedbackByCourseId(@PathVariable Long courseId) {
        List<Feedback> feedbacks = feedbackRepository.findByCourseId(courseId);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    /**
     * 
     */
    @PostMapping("/createFeedback")
    public ResponseEntity<Feedback> createFeedbackForCourse(@Valid @RequestBody Feedback feedback) {
        Feedback newFeedback = feedbackRepository.save(feedback);
        return new ResponseEntity<>(newFeedback, HttpStatus.CREATED);

    }          
}
