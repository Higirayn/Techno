package org.example.tz.controller;

import org.example.tz.dto.LocationResponse;
import org.example.tz.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping
    public LocationResponse getLocation(@RequestHeader(value = "X-Forwarded-For", required = false) String xForwardedFor,
                                        @RequestHeader(value = "X-Real-IP", required = false) String xRealIp,
                                        HttpServletRequest request) {
        String ip = xForwardedFor != null ? xForwardedFor.split(",")[0].trim() :
                    xRealIp != null ? xRealIp :
                    request.getRemoteAddr();
        return locationService.getLocationByIp(ip);
    }
} 