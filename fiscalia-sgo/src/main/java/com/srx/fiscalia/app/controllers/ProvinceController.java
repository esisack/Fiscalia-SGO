package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Province;
import com.srx.fiscalia.app.repository.ProvinceRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinceController {

    private final ProvinceRepository provinceRepository;

    public ProvinceController(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/provinces")
    public List<Province> getProvinces() {
        return (List<Province>) provinceRepository.findAll();
    }

    @PostMapping("/provinces")
    void addProvince(@RequestBody Province province) {
        provinceRepository.save(province);
    }
       
}