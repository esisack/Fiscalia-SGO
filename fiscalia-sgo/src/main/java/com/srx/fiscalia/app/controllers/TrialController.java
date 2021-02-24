package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Trial;
import com.srx.fiscalia.app.repository.TrialRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrialController {

    private final TrialRepository trialRepository;

    public TrialController(TrialRepository trialRepository) {
        this.trialRepository = trialRepository;
    }

    @GetMapping("/trials")
    public List<Trial> getTrialss() {
        return (List<Trial>) trialRepository.findAll();
    }

    @PostMapping("/trials")
    void addTrial(@RequestBody Trial trial) {
        trialRepository.save(trial);
    }
       
}