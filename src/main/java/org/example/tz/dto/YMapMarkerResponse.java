package org.example.tz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class YMapMarkerResponse {
    private long id;
    private double lat;
    private double lon;
    private String label;
    private String description;
} 