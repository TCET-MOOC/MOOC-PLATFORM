package com.MOOC.OnlineLearningPlatfrom.Service;

import com.MOOC.OnlineLearningPlatfrom.Entity.Course;
import java.util.List;
import java.util.Optional; // Use Optional for "find by ID" methods

public interface CourseService {
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long id); // Changed to return Optional
    Course createCourse(Course course);
    Optional<Course> updateCourse(Long id, Course courseDetails); // Changed to return Optional
    void deleteCourse(Long id); // Good to have a delete method
}