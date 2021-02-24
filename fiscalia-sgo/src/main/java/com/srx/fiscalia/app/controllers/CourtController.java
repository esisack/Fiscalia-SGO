package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Court;
import com.srx.fiscalia.app.repository.CourtRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CourtController {

    private final CourtRepository courtRepository;

    public CourtController(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    @GetMapping("/courts")
    public List<Court> getCourts() {
        return (List<Court>) courtRepository.findAll();
    }

    @PostMapping("/courts")
    void addCourt(@RequestBody Court court) {
        courtRepository.save(court);
    }
       
}