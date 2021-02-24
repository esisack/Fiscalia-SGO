package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Job;
import com.srx.fiscalia.app.repository.JobRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JobController {

    private final JobRepository jobRepository;

    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping("/jobs")
    public List<Job> getJobs() {
        return (List<Job>) jobRepository.findAll();
    }

    @PostMapping("/jobs")
    void addJob(@RequestBody Job job) {
        jobRepository.save(job);
    }
       
}