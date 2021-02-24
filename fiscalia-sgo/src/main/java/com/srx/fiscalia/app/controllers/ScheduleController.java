package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Schedule;
import com.srx.fiscalia.app.repository.ScheduleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ScheduleController {

    private final ScheduleRepository scheduleRepository;

    public ScheduleController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/schedules")
    public List<Schedule> getSchedules() {
        return (List<Schedule>) scheduleRepository.findAll();
    }

    @PostMapping("/schedules")
    void addSchedule(@RequestBody Schedule schedule) {
        scheduleRepository.save(schedule);
    }
       
}