package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- ADDED/CHANGED IMPORTS ---
import com.MOOC.OnlineLearningPlatfrom.Entity.CourseContent;
import com.MOOC.OnlineLearningPlatfrom.Service.CourseContentService; // Import the service
// --- END ---

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contents") // Base path for all CourseContent APIs
public class CourseContentController {

    // --- Inject the Service ---
    private final CourseContentService contentService;

    // --- Constructor Injection for the Service ---
    public CourseContentController(CourseContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping // GET -> fetch all contents
    public List<CourseContent> getAllContents() {
        // --- Call the service ---
        return contentService.getAllContents();
    }

    // --- ADDED: Get by ID endpoint ---
    @GetMapping("/{id}")
    public ResponseEntity<CourseContent> getContentById(@PathVariable Long id) {
        return contentService.getContentById(id)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    @PostMapping // POST -> add new content
    public CourseContent createContent(@RequestBody CourseContent content) {
        // --- Call the service ---
        return contentService.createContent(content);
    }

    @PutMapping("/{id}") // PUT -> update existing content by ID
    public ResponseEntity<CourseContent> updateContent(@PathVariable Long id, @RequestBody CourseContent contentDetails) {
        // --- Call the service and map the Optional response ---
        return contentService.updateContent(id, contentDetails)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    // --- ADDED: Delete endpoint ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable Long id) {
        try {
            contentService.deleteContent(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}