package com.MOOC.OnlineLearningPlatfrom.Service.impl;

import com.MOOC.OnlineLearningPlatfrom.Entity.Course;
import com.MOOC.OnlineLearningPlatfrom.Repository.CourseRepository;
import com.MOOC.OnlineLearningPlatfrom.Service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // <-- Tell Spring this is a Service bean
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository; // <-- Inject the Repository here

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        // This is the logic moved from the controller
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        // This logic is also moved from the controller
        return courseRepository.findById(id);
    }

    @Override
    public Course createCourse(Course course) {
        // Logic moved from controller
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> updateCourse(Long id, Course courseDetails) {
        // This is the full business logic for an update
        return courseRepository.findById(id).map(existingCourse -> {
            existingCourse.setTitle(courseDetails.getTitle());
            existingCourse.setDescription(courseDetails.getDescription());
            existingCourse.setDepartmentId(courseDetails.getDepartmentId());
            existingCourse.setCreatorId(courseDetails.getCreatorId());
            return courseRepository.save(existingCourse);
        });
        // If findById was empty, the Optional will be empty, 
        // which the controller will handle.
    }

    @Override
    public void deleteCourse(Long id) {
        // We should check if it exists first
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            // Or throw an exception
            throw new RuntimeException("Course not found with id: " + id);
        }
    }
}