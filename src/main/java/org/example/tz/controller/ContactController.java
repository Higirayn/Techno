package org.example.tz.controller;

import org.example.tz.dto.ContactRequest;
import org.example.tz.dto.ContactResponse;
import org.example.tz.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public ContactResponse send(@RequestBody ContactRequest request) {
        return contactService.sendContactMessage(request);
    }
} 