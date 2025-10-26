package com.MOOC.OnlineLearningPlatfrom.Controller;

import com.MOOC.OnlineLearningPlatfrom.Entity.LeaderBoard;
import com.MOOC.OnlineLearningPlatfrom.Repository.LeaderBoardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 */
@RestController
@RequestMapping("/api")
public class LeaderBoardController {

    /**
     * 
     */
    private LeaderBoardRepository leaderBoardRepository;

    /**
     * Constructor injection (Spring will inject the repository automatically)
     */
    public LeaderBoardController(LeaderBoardRepository leaderBoardRepository) {
        this.leaderBoardRepository = leaderBoardRepository;
    }

    /**
     * 
     */
    @GetMapping
    public List<LeaderBoard> getLeaderboard() {
        return leaderBoardRepository.findTop10ByOrderByAvgScoreDesc();
    }

    /**
     * 
     */
    @GetMapping("/course/{courseId}")
    public List<LeaderBoard> getLeaderboardByCourse(@PathVariable Long courseId) {
    return leaderBoardRepository.findTop10ByCourseIdOrderByAvgScoreDesc(courseId);
    }   
}
