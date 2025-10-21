package com.MOOC.OnlineLearningPlatfrom.Service;

import com.MOOC.OnlineLearningPlatfrom.Entity.Question;
import com.MOOC.OnlineLearningPlatfrom.Entity.StudentAnswer;
import com.MOOC.OnlineLearningPlatfrom.Entity.Test;
import com.MOOC.OnlineLearningPlatfrom.Entity.TestAttempt;
import com.MOOC.OnlineLearningPlatfrom.Repository.QuestionRepository;
import com.MOOC.OnlineLearningPlatfrom.Repository.StudentAnswerRepository;
import com.MOOC.OnlineLearningPlatfrom.Repository.TestAttemptRepository;
import com.MOOC.OnlineLearningPlatfrom.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private TestAttemptRepository testAttemptRepository;

    @Autowired
    private StudentAnswerRepository studentAnswerRepository;

    // --- Test Methods (No change here) ---
    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    // --- Question Methods (Updated Logic) ---
    public Question addQuestionToTest(Long testId, Question question) {
        // Find the Test object from the database using the testId
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + testId));

        // Set the full Test object on the question
        question.setTest(test);

        // Save the question, now linked to the test
        return questionRepository.save(question);
    }

    // --- Test Attempt Methods (Updated Logic) ---
    public TestAttempt startTestAttempt(Long testId, Long userId) {
        // Find the Test object
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + testId));

        // Create a new attempt
        TestAttempt newAttempt = new TestAttempt();
        newAttempt.setTest(test); // Link the Test object
        newAttempt.setUserId(userId);
        newAttempt.setAttemptedAt(LocalDateTime.now());
        newAttempt.setStatus("IN_PROGRESS");

        return testAttemptRepository.save(newAttempt);
    }

    // --- Student Answer Methods (Updated Logic) ---
    public StudentAnswer submitAnswer(Long attemptId, Long questionId, StudentAnswer studentAnswer) {
        // Find the TestAttempt object
        TestAttempt attempt = testAttemptRepository.findById(attemptId)
                .orElseThrow(() -> new RuntimeException("Attempt not found with id: " + attemptId));

        // Find the Question object
        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found with id: " + questionId));

        // Link the full objects to the answer
        studentAnswer.setAttempt(attempt);
        studentAnswer.setQuestion(question);

        // Logic to grade the answer could be added here later
        return studentAnswerRepository.save(studentAnswer);
    }

    // Add this new method inside your TestService class

    public TestAttempt calculateAndFinalizeScore(Long attemptId) {
        // 1. Find the attempt we want to score.
        TestAttempt attempt = testAttemptRepository.findById(attemptId)
                .orElseThrow(() -> new RuntimeException("Attempt not found with id: " + attemptId));

        // 2. Get all the student's answers for this attempt.
        List<StudentAnswer> answers = attempt.getStudentAnswers();

        // 3. Calculate the total score.
        int totalScore = 0;
        for (StudentAnswer answer : answers) {
            // This is a placeholder for a real grading engine.
            // For now, we'll give full marks if the answer is not empty.
            if (answer.getAnswerText() != null && !answer.getAnswerText().isEmpty()) {
                int marksForQuestion = answer.getQuestion().getMarks();
                answer.setMarksAwarded(marksForQuestion); // Set marks for this answer
                totalScore += marksForQuestion; // Add to the total
            } else {
                answer.setMarksAwarded(0); // Give 0 marks for empty answers
            }
            // Save the updated marks for each answer
            studentAnswerRepository.save(answer);
        }

        // 4. Update the TestAttempt with the final score and status.
        attempt.setScore(totalScore);
        attempt.setStatus("COMPLETED");

        // 5. Save the final result and return it.
        return testAttemptRepository.save(attempt);
    }

    // Add these new methods inside your TestService class

    // GET a single test by its ID
    public Test getTestById(Long testId) {
        return testRepository.findById(testId)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + testId));
    }

    // PUT (update) an entire test
    public Test updateTest(Long testId, Test testDetails) {
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + testId));

        test.setTitle(testDetails.getTitle());
        test.setDurationMinutes(testDetails.getDurationMinutes());
        test.setSecurityPolicy(testDetails.getSecurityPolicy());
        // You can add more fields to update here

        return testRepository.save(test);
    }

    // DELETE a test
    public void deleteTest(Long testId) {
        Test test = testRepository.findById(testId)
                .orElseThrow(() -> new RuntimeException("Test not found with id: " + testId));
        testRepository.delete(test);
    }
}