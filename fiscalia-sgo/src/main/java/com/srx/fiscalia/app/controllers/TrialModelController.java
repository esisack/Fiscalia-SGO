package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.TrialModel;
import com.srx.fiscalia.app.repository.TrialModelRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrialModelController {

    private final TrialModelRepository trialModelRepository;

    public TrialModelController(TrialModelRepository trialModelRepository) {
        this.trialModelRepository = trialModelRepository;
    }

    @GetMapping("/trialModels")
    public List<TrialModel> getTrialModels() {
        return (List<TrialModel>) trialModelRepository.findAll();
    }

    @PostMapping("/trialModels")
    void addTrialModel(@RequestBody TrialModel trialModel) {
        trialModelRepository.save(trialModel);
    }
       
}