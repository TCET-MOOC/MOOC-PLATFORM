package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- IMPORT YOUR NEW SERVICE ---
import com.MOOC.OnlineLearningPlatfrom.Service.CourseService; 
// --- NO LONGER NEED REPOSITORY IMPORTS ---
import com.MOOC.OnlineLearningPlatfrom.Entity.Course;
// --- You might still need Module imports if you add module methods ---

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    // --- Inject the SERVICE, not the Repository ---
    private final CourseService courseService;

    // --- Constructor injection for the SERVICE ---
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping // GET -> fetch all courses
    public List<Course> getAllCourses() {
        // --- Call the service ---
        return courseService.getAllCourses(); 
    }

    @GetMapping("/{id}") // GET -> fetch course by ID
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        // --- The controller maps the Optional to a Response ---
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    @PostMapping // POST -> add new course
    public Course createCourse(@RequestBody Course course) {
        // --- Call the service ---
        return courseService.createCourse(course); 
    }

    @PutMapping("/{id}") // PUT -> update existing course by ID
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        // --- The controller maps the Optional to a Response ---
        return courseService.updateCourse(id, courseDetails)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }
    
    // --- You should also add a DELETE endpoint ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        try {
            courseService.deleteCourse(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) {
            // This catches the "Not Found" exception from the service
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}