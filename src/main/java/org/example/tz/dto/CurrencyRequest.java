package org.example.tz.dto;

import lombok.Data;

@Data
public class CurrencyRequest {
    private String from;
    private String to;
    private double amount;
} 