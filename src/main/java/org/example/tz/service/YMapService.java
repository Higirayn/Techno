package org.example.tz.service;

import org.example.tz.dto.YMapMarkerRequest;
import org.example.tz.dto.YMapMarkerResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class YMapService {
    private final List<YMapMarkerResponse> markers = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public YMapMarkerResponse addMarker(YMapMarkerRequest req) {
        YMapMarkerResponse marker = new YMapMarkerResponse(
                idGen.getAndIncrement(),
                req.getLat(),
                req.getLon(),
                req.getLabel(),
                req.getDescription()
        );
        markers.add(marker);
        return marker;
    }

    public List<YMapMarkerResponse> getMarkers() {
        return new ArrayList<>(markers);
    }
} 