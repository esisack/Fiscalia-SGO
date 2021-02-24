package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.City;
import com.srx.fiscalia.app.repository.CityRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CityController {

    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping("/cities")
    public List<City> getCities() {
        return (List<City>) cityRepository.findAll();
    }

    @PostMapping("/cities")
    void addCity(@RequestBody City city) {
        cityRepository.save(city);
    }
       
}