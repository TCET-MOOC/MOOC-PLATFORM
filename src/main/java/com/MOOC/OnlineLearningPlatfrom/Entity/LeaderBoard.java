package com.MOOC.OnlineLearningPlatfrom.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * LeaderBoard entity for tracking student performance and ranks
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leaderboard")
public class LeaderBoard {

    /**
     * Primary key for LeaderBoard
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaderboardId;

    /**
     * User ID maps to user entity
     */
    @Column(nullable = false)
    private Long userId;

    /**
     * Course ID maps to course entity
     */
    @Column(nullable = false)
    private Long courseId;

    /**
     * Average score of the user 
     */
    @Column(nullable = true)
    private Double avgScore;

    /**
     * Institute rank of the user
     */
    @Column(nullable = true)
    private Integer instituteRank;

    /**
     * Department rank of the user
     */
    @Column(nullable = true)
    private Integer deptRank;

    /**
     * Last updated timestamp
     */
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
}
