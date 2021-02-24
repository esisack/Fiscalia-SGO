package com.srx.fiscalia.app.controllers;


import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srx.fiscalia.app.entities.Contact;
import com.srx.fiscalia.app.repository.ContactRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping("/contacts")
    public List<Contact> getContacts() {
        return (List<Contact>) contactRepository.findAll();
    }

    @PostMapping("/contacts")
    void addContact(@RequestBody Contact contact) {
        contactRepository.save(contact);
    }
       
}