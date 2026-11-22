package com.project.fitness.repository;

import com.project.fitness.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {     // JpaRepository -- ye hame prebuilt method deti hai jike jariye ham  data base se ham intract kra sakte ha00i
    List<Activity> findByUserId(String userId);        // FindBy ka matlab select query , By ka matlab bare class .. jaha ham data base me filter lagana chah rhe hai, UserId ka matlab ak field hai
}
