package com.MOOC.OnlineLearningPlatfrom.Repository;

import com.MOOC.OnlineLearningPlatfrom.Entity.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 
 */
public interface LeaderBoardRepository extends JpaRepository <LeaderBoard, Long>{
    List<LeaderBoard> findTop10ByOrderByAvgScoreDesc();
    List<LeaderBoard> findTop10ByCourseIdOrderByAvgScoreDesc(Long courseId);
}
