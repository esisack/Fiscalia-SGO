package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.TrialTeam;
import com.srx.fiscalia.app.repository.TrialTeamRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrialTeamController {

    private final TrialTeamRepository trialTeamRepository;

    public TrialTeamController(TrialTeamRepository trialTeamRepository) {
        this.trialTeamRepository = trialTeamRepository;
    }

    @GetMapping("/trialTeams")
    public List<TrialTeam> getTrialTeams() {
        return (List<TrialTeam>) trialTeamRepository.findAll();
    }

    @PostMapping("/trialTeams")
    void addTrialTeam(@RequestBody TrialTeam trialTeam) {
        trialTeamRepository.save(trialTeam);
    }
       
}