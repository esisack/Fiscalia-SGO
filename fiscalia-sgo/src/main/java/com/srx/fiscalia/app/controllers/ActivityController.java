package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Activity;
import com.srx.fiscalia.app.repository.ActivityRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {

    private final ActivityRepository activityRepository;

    public ActivityController(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @GetMapping("/activities")
    public List<Activity> getActivities() {
        return (List<Activity>) activityRepository.findAll();
    }

    @PostMapping("/activities")
    void addActivity(@RequestBody Activity activity) {
        activityRepository.save(activity);
    }
       
}