package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- NEW IMPORTS ---
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.MOOC.OnlineLearningPlatfrom.Entity.Enrollment;
import com.MOOC.OnlineLearningPlatfrom.Entity.UserProgress;
import com.MOOC.OnlineLearningPlatfrom.Service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EnrollmentController {

    // --- NEW LOGGER DEFINITION ---
    private static final Logger log = LoggerFactory.getLogger(EnrollmentController.class);

    @Autowired
    private EnrollmentService enrollmentService;

    // Endpoint to enroll a user in a course
    @PostMapping("/enrollments")
    public ResponseEntity<Enrollment> enrollInCourse(@RequestBody Enrollment enrollment) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/enrollments");
        Enrollment newEnrollment = enrollmentService.enrollUser(enrollment);
        return ResponseEntity.ok(newEnrollment);
    }

    // Endpoint to log or update a user's progress on a piece of content
    @PostMapping("/progress")
    public ResponseEntity<UserProgress> logUserProgress(@RequestBody UserProgress userProgress) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/progress");
        UserProgress updatedProgress = enrollmentService.updateUserProgress(userProgress);
        return ResponseEntity.ok(updatedProgress);
    }
}