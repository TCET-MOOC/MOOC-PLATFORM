package com.MOOC.OnlineLearningPlatfrom.Controller;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
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
    private final PostRepository postRepository;

    /**
     * 
     */
    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    /**
     * 
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Long userId){
        List<Post> posts = postRepository.findByUserId(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    /**
     * 
     */
    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost(@Valid @RequestBody  Post post) {
        Post newPost = postRepository.save(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }
}
