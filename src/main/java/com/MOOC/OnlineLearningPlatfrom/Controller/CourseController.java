package com.MOOC.OnlineLearningPlatfrom.Controller;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses") // Base API path for courses
public class CourseController {

    private final CourseRepository courseRepo; // Repository for DB operations

    // Constructor injection for repository
    public CourseController(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    @GetMapping // GET -> fetch all courses
    public List<Course> getAllCourses() {
        return courseRepo.findAll(); // return all courses from DB
    }

    @GetMapping("/{id}") // GET -> fetch course by ID
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        return courseRepo.findById(id)
                .map(ResponseEntity::ok) // return course if found
                .orElse(ResponseEntity.notFound().build()); // else return 404
    }

    @PostMapping // POST -> add new course
    public Course createCourse(@RequestBody Course course) {
        return courseRepo.save(course); // save new course in DB
    }

    @PutMapping("/{id}") // PUT -> update existing course by ID
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseRepo.findById(id).map(course -> {
            // update fields
            course.setTitle(courseDetails.getTitle());           // update title
            course.setDescription(courseDetails.getDescription()); // update description
            course.setDepartmentId(courseDetails.getDepartmentId()); // update department
            course.setCreatorId(courseDetails.getCreatorId());   // update creator

            return ResponseEntity.ok(courseRepo.save(course)); // save and return updated course
        }).orElse(ResponseEntity.notFound().build()); // return 404 if course not found
    }
}
