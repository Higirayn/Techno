package org.example.tz.service;

import org.example.tz.dto.ContactRequest;
import org.example.tz.dto.ContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username:admin@example.com}")
    private String toEmail;

    public ContactResponse sendContactMessage(ContactRequest request) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(toEmail);
            message.setSubject("Contact Form Message from " + request.getName());
            message.setText("From: " + request.getEmail() + "\n\n" + request.getMessage());
            mailSender.send(message);
            return new ContactResponse(true, "Message sent successfully");
        } catch (Exception e) {
            return new ContactResponse(false, "Failed to send message: " + e.getMessage());
        }
    }
} 