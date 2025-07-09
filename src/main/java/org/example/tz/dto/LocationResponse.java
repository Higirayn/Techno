package org.example.tz.dto;

import lombok.Data;

@Data
public class LocationResponse {
    private String city;
    private String country;
    private String region;
    private String lat;
    private String lon;
    private String ip;
} 