package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.File;
import com.srx.fiscalia.app.repository.FileRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FileController {

    private final FileRepository fileRepository;

    public FileController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @GetMapping("/files")
    public List<File> getFiles() {
        return (List<File>) fileRepository.findAll();
    }

    @PostMapping("/files")
    void addFile(@RequestBody File file) {
        fileRepository.save(file);
    }
       
}