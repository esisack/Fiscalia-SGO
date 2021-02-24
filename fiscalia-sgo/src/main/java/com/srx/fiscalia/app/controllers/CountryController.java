package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Country;
import com.srx.fiscalia.app.repository.CountryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return (List<Country>) countryRepository.findAll();
    }

    @PostMapping("/countries")
    void addCountry(@RequestBody Country country) {
        countryRepository.save(country);
    }
       
}