package com.MOOC.OnlineLearningPlatfrom.Controller;

// --- ADDED/CHANGED IMPORTS ---
import com.MOOC.OnlineLearningPlatfrom.Entity.Post;
import com.MOOC.OnlineLearningPlatfrom.Service.PostService; // Import the service
// --- END ---

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    /**
     *
     */
    // --- Inject the Service ---
    private final PostService postService;

    /**
     *
     */
    // --- Use Constructor Injection for the Service ---
    public PostController(PostService postService) {
        this.postService = postService;
    }

    /**
     *
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long userId) {
        // --- Call the service ---
        List<Post> posts = postService.getPostsByUserId(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    /**
     *
     */
    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post) {
        // --- Call the service ---
        Post newPost = postService.createPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    // --- OPTIONAL: Good to add GetByID and Delete endpoints ---

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        return postService.getPostById(id)
                .map(ResponseEntity::ok) // 200 OK
                .orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        try {
            postService.deletePost(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (Exception e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}