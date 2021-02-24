package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Area;
import com.srx.fiscalia.app.repository.AreaRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AreaController {

    private final AreaRepository areaRepository;

    public AreaController(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @GetMapping("/areas")
    public List<Area> getAreas() {
        return (List<Area>) areaRepository.findAll();
    }

    @PostMapping("/areas")
    void addArea(@RequestBody Area area) {
        areaRepository.save(area);
    }
       
}