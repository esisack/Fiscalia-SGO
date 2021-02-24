package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Stage;
import com.srx.fiscalia.app.repository.StageRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StageController {

    private final StageRepository stageRepository;

    public StageController(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    @GetMapping("/stages")
    public List<Stage> getStages() {
        return (List<Stage>) stageRepository.findAll();
    }

    @PostMapping("/stages")
    void addStage(@RequestBody Stage stage) {
        stageRepository.save(stage);
    }
       
}