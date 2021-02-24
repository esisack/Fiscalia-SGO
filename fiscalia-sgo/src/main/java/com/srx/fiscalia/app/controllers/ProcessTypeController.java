package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.ProcessType;
import com.srx.fiscalia.app.repository.ProcessTypeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProcessTypeController {

    private final ProcessTypeRepository processTypeRepository;

    public ProcessTypeController(ProcessTypeRepository processTypeRepository) {
        this.processTypeRepository = processTypeRepository;
    }

    @GetMapping("/processTypes")
    public List<ProcessType> getProcessTypes() {
        return (List<ProcessType>) processTypeRepository.findAll();
    }

    @PostMapping("/processTypes")
    void addProcessType(@RequestBody ProcessType processType) {
        processTypeRepository.save(processType);
    }
       
}