package com.project.fitness.controller;


import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Recommendation;
import com.project.fitness.service.RecommendationService;
 import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService ;    // RecommendationService -- ye string manage component hai

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(
            @RequestBody  RecommendationRequest request
    ) {
        Recommendation recommendation = recommendationService.generateRecommendation(request);
             return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> generateRecommendation(
           @PathVariable String userId               // sabse  pahle ham method ko declare karenge
    ) {
        List<Recommendation>  recommendationList = recommendationService.getUserRecommendation(userId);
        return  ResponseEntity.ok(recommendationList);
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(
            @PathVariable String activityId               // sabse  pahle ham method ko declare karenge
    ) {
        List<Recommendation>  recommendationList = recommendationService.getActivityRecommendation(activityId);
        return  ResponseEntity.ok(recommendationList);
    }
}

















