package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Company;
import com.srx.fiscalia.app.repository.CompanyRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return (List<Company>) companyRepository.findAll();
    }

    @PostMapping("/companies")
    void addCompany(@RequestBody Company company) {
        companyRepository.save(company);
    }
       
}