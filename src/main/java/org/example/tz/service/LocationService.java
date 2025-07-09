package org.example.tz.service;

import org.example.tz.dto.LocationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocationService {
    private final RestTemplate restTemplate = new RestTemplate();

    public LocationResponse getLocationByIp(String ip) {
        String url = "http://ip-api.com/json/" + ip + "?fields=status,country,regionName,city,lat,lon,query";
        var response = restTemplate.getForObject(url, java.util.Map.class);
        LocationResponse result = new LocationResponse();
        if (response != null && "success".equals(response.get("status"))) {
            result.setCity((String) response.get("city"));
            result.setCountry((String) response.get("country"));
            result.setRegion((String) response.get("regionName"));
            result.setLat(String.valueOf(response.get("lat")));
            result.setLon(String.valueOf(response.get("lon")));
            result.setIp((String) response.get("query"));
        }
        return result;
    }
} 