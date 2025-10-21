package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- NEW IMPORTS ---
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.MOOC.OnlineLearningPlatfrom.Entity.Question;
import com.MOOC.OnlineLearningPlatfrom.Entity.StudentAnswer;
import com.MOOC.OnlineLearningPlatfrom.Entity.Test;
import com.MOOC.OnlineLearningPlatfrom.Entity.TestAttempt;
import com.MOOC.OnlineLearningPlatfrom.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api") // Changed to a common base path
public class TestController {

    // --- NEW LOGGER DEFINITION ---
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    // --- Endpoints for Tests ---
    // POST /api/tests
    @PostMapping("/tests")
    public ResponseEntity<Test> createTest(@RequestBody Test test) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/tests");
        return ResponseEntity.ok(testService.createTest(test));
    }

    // POST /api/attempts/{attemptId}/finalize
    @PostMapping("/attempts/{attemptId}/finalize")
    public ResponseEntity<TestAttempt> finalizeTest(@PathVariable Long attemptId) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/attempts/{}/finalize", attemptId);
        return ResponseEntity.ok(testService.calculateAndFinalizeScore(attemptId));
    }

    // GET /api/tests
    @GetMapping("/tests")
    public ResponseEntity<List<Test>> getAllTests() {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for GET /api/tests");
        return ResponseEntity.ok(testService.getAllTests());
    }

    // --- Endpoints for Questions ---
    // POST /api/tests/{testId}/questions
    @PostMapping("/tests/{testId}/questions")
    public ResponseEntity<Question> addQuestion(@PathVariable Long testId, @RequestBody Question question) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/tests/{}/questions", testId);
        return ResponseEntity.ok(testService.addQuestionToTest(testId, question));
    }

    // --- Endpoints for Attempts and Answers ---
    // POST /api/tests/{testId}/attempts
    @PostMapping("/tests/{testId}/attempts")
    public ResponseEntity<TestAttempt> startTest(@PathVariable Long testId, @RequestBody Map<String, Long> payload) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/tests/{}/attempts", testId);
        Long userId = payload.get("userId");
        return ResponseEntity.ok(testService.startTestAttempt(testId, userId));
    }

    // POST /api/attempts/{attemptId}/answers
    @PostMapping("/attempts/{attemptId}/answers")
    public ResponseEntity<StudentAnswer> submitAnswer(@PathVariable Long attemptId, @RequestBody StudentAnswer studentAnswer) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for POST /api/attempts/{}/answers", attemptId);
        // The request body will contain questionId and answerText. We pass the whole object.
        Long questionId = studentAnswer.getQuestion().getQuestionId();
        return ResponseEntity.ok(testService.submitAnswer(attemptId, questionId, studentAnswer));
    }
    // Add these new methods inside your TestController class

    // GET /api/tests/{testId}
    @GetMapping("/tests/{testId}")
    public ResponseEntity<Test> getTestById(@PathVariable Long testId) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for GET /api/tests/{}", testId);
        return ResponseEntity.ok(testService.getTestById(testId));
    }

    // PUT /api/tests/{testId}
    @PutMapping("/tests/{testId}")
    public ResponseEntity<Test> updateTest(@PathVariable Long testId, @RequestBody Test testDetails) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for PUT /api/tests/{}", testId);
        return ResponseEntity.ok(testService.updateTest(testId, testDetails));
    }

    // DELETE /api/tests/{testId}
    @DeleteMapping("/tests/{testId}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long testId) {
        // --- NEW LOG MESSAGE ---
        log.info("Request received for DELETE /api/tests/{}", testId);
        testService.deleteTest(testId);
        return ResponseEntity.noContent().build(); // Standard response for a successful delete
    }
}