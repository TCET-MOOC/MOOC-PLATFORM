package com.MOOC.OnlineLearningPlatfrom.Controller;

import com.example.demo.entity.CourseContent;
import com.example.demo.repository.CourseContentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contents") // Base path for all CourseContent APIs
public class CourseContentController {

    private final CourseContentRepository contentRepo; // DB access layer

    // Constructor Injection for repository
    public CourseContentController(CourseContentRepository contentRepo) {
        this.contentRepo = contentRepo;
    }

    @GetMapping // GET -> fetch all contents
    public List<CourseContent> getAllContents() {
        return contentRepo.findAll();
    }

    @PostMapping // POST -> add new content
    public CourseContent createContent(@RequestBody CourseContent content) {
        return contentRepo.save(content);
    }

    @PutMapping("/{id}") // PUT -> update existing content by ID
    public ResponseEntity<CourseContent> updateContent(@PathVariable Long id, @RequestBody CourseContent contentDetails) {
        return contentRepo.findById(id).map(content -> {
            // update fields
            content.setTitle(contentDetails.getTitle());              // update title  
            content.setContentType(contentDetails.getContentType());  // update type (video/pdf etc.)  
            content.setFilePath(contentDetails.getFilePath());        // update file path/location  
            content.setDurationSeconds(contentDetails.getDurationSeconds()); // update duration in seconds  
            content.setPosition(contentDetails.getPosition());        // update order/position in course  

            
            return ResponseEntity.ok(contentRepo.save(content)); // save updated content
        }).orElse(ResponseEntity.notFound().build()); // if not found return 404
    }
}
