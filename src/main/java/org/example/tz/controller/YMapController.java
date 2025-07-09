package org.example.tz.controller;

import org.example.tz.dto.YMapMarkerRequest;
import org.example.tz.dto.YMapMarkerResponse;
import org.example.tz.service.YMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ymap")
public class YMapController {
    @Autowired
    private YMapService yMapService;

    @PostMapping("/marker")
    public YMapMarkerResponse addMarker(@RequestBody YMapMarkerRequest request) {
        return yMapService.addMarker(request);
    }

    @GetMapping("/markers")
    public List<YMapMarkerResponse> getMarkers() {
        return yMapService.getMarkers();
    }
} 