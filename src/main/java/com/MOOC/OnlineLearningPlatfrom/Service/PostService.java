package com.MOOC.OnlineLearningPlatfrom.Service;

import com.MOOC.OnlineLearningPlatfrom.Entity.Post;
import java.util.List;
import java.util.Optional;

public interface PostService {

    /**
     * Creates and saves a new post.
     * @param post The post object to save.
     * @return The saved post object with its generated ID.
     */
    Post createPost(Post post);

    /**
     * Retrieves all posts made by a specific user.
     * @param userId The ID of the user.
     * @return A list of post objects.
     */
    List<Post> getPostsByUserId(Long userId);

    /**
     * Retrieves a single post by its ID.
     * @param postId The ID of the post.
     * @return An Optional containing the post if found, or empty if not.
     */
    Optional<Post> getPostById(Long postId);

    /**
     * Deletes a post by its ID.
     * @param postId The ID of the post to delete.
     */
    void deletePost(Long postId);
}