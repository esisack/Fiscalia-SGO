package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Issue;
import com.srx.fiscalia.app.repository.IssueRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IssueController {

    private final IssueRepository issueRepository;

    public IssueController(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @GetMapping("/issues")
    public List<Issue> getIssues() {
        return (List<Issue>) issueRepository.findAll();
    }

    @PostMapping("/issues")
    void addIssue(@RequestBody Issue issue) {
        issueRepository.save(issue);
    }
       
}