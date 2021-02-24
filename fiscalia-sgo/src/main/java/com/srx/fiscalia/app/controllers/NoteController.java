package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Note;
import com.srx.fiscalia.app.repository.NoteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return (List<Note>) noteRepository.findAll();
    }

    @PostMapping("/notes")
    void addNote(@RequestBody Note note) {
        noteRepository.save(note);
    }
       
}