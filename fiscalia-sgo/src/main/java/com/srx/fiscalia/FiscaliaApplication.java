package com.srx.fiscalia;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.srx.fiscalia.app.entities.Trial;
import com.srx.fiscalia.app.repository.TrialRepository;



@SpringBootApplication
@ComponentScan
public class FiscaliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiscaliaApplication.class, args);
	}

	@Bean
    CommandLineRunner init(TrialRepository trialRepository) {
        return args -> {
        	List<Trial> trials = (List<Trial>) trialRepository.findAll();
        	trials.forEach(System.out::println);
        };
        
		/*
		 * return args -> {
		 * 
		 * Role adminRole = roleRepository.findByRole("ADMIN"); if (adminRole == null) {
		 * Role newAdminRole = new Role(); newAdminRole.setRole("ADMIN");
		 * roleRepository.save(newAdminRole); }
		 * 
		 * Role userRole = roleRepository.findByRole("USER"); if (userRole == null) {
		 * Role newUserRole = new Role(); newUserRole.setRole("USER");
		 * roleRepository.save(newUserRole); } };
		 * 
		 */  
        }
	
}
