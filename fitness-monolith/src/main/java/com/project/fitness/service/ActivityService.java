package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
  private final ActivityRepository activityRepository;
  private final UserRepository userRepository;

    public  ActivityResponse trackActivity(ActivityRequest request) {
        User user = userRepository.findById(request.getUserId())      // ham user ko retrive karenge                  // user  ko hamko import karna padega
                .orElseThrow(() -> new RuntimeException("Invalid user: " + request.getUserId()));
       Activity activity =  Activity.builder()
               .user(user)
               .type(request.getType())
               .duration(request.getDuration())
               .caloriesBurned(request.getCaloriesBurned())
               .startTime(request.getStartTime())
               .additionalMatrics(request.getAdditionalMatrices())
               .build();


       Activity saveActivity = activityRepository.save(activity);     // ham repository ke help se isko save kar denge
        return mapToResponse(saveActivity);
    }

    private ActivityResponse mapToResponse(Activity  activity) {
        ActivityResponse response =  new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUser().getId());    //  sabse pahle ham user ko get kiye hai fir uski id retrive ki hai . fir usi id ko ham set kar rhe hai
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMatrices(activity.getAdditionalMatrics());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());

        return  response;
    }

    public  List<ActivityResponse> getUserActivities(String userId) {
        List<Activity> activityList  = activityRepository.findByUserId(userId);
//        1. Activity -->> ActivityResponse
//            2-->> Collect in list and return
        return activityList.stream()
                .map(this::mapToResponse)       // activity ke object isme map honge
                .collect(Collectors.toList());
    }
}













