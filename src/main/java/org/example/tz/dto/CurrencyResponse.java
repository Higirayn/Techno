package org.example.tz.dto;

import lombok.Data;

@Data
public class CurrencyResponse {
    private String from;
    private String to;
    private double amount;
    private double rate;
    private double result;
    private String date;
} 