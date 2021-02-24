package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Evento;
import com.srx.fiscalia.app.repository.EventoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EventoController {

    private final EventoRepository eventoRepository;

    public EventoController(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @GetMapping("/eventos")
    public List<Evento> getEventos() {
        return (List<Evento>) eventoRepository.findAll();
    }

    @PostMapping("/eventos")
    void addEvento(@RequestBody Evento evento) {
        eventoRepository.save(evento);
    }
       
}