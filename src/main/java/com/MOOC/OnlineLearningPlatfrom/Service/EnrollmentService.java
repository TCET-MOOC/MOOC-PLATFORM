package com.MOOC.OnlineLearningPlatfrom.Service;

import com.MOOC.OnlineLearningPlatfrom.Repository.EnrollmentRepository;
import com.MOOC.OnlineLearningPlatfrom.Repository.UserProgressRepository;
import com.MOOC.OnlineLearningPlatfrom.Entity.Enrollment;
import com.MOOC.OnlineLearningPlatfrom.Entity.UserProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private UserProgressRepository userProgressRepository;

    // --- Enrollment Logic ---
    public Enrollment enrollUser(Enrollment enrollment) {
        enrollment.setEnrolledAt(LocalDateTime.now());
        return enrollmentRepository.save(enrollment);
    }

    // --- User Progress Logic ---
    public UserProgress updateUserProgress(UserProgress userProgress) {
        if (userProgress.getProgressPercent() != null && userProgress.getProgressPercent() >= 100) {
            userProgress.setCompletedAt(LocalDateTime.now());
        }
        return userProgressRepository.save(userProgress);
    }
}
