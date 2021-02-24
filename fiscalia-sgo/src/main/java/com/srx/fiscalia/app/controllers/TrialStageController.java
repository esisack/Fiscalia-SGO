package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.TrialStage;
import com.srx.fiscalia.app.repository.TrialStageRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrialStageController {

    private final TrialStageRepository trialStageRepository;

    public TrialStageController(TrialStageRepository trialStageRepository) {
        this.trialStageRepository = trialStageRepository;
    }

    @GetMapping("/trialStages")
    public List<TrialStage> getTrialStages() {
        return (List<TrialStage>) trialStageRepository.findAll();
    }

    @PostMapping("/trialStages")
    void addTrialStage(@RequestBody TrialStage trialStage) {
        trialStageRepository.save(trialStage);
    }
       
}