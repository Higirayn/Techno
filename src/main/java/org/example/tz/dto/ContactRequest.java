package org.example.tz.dto;

import lombok.Data;

@Data
public class ContactRequest {
    private String name;
    private String email;
    private String message;
} 