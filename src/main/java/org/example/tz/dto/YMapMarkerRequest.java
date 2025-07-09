package org.example.tz.dto;

import lombok.Data;

@Data
public class YMapMarkerRequest {
    private double lat;
    private double lon;
    private String label;
    private String description;
} 