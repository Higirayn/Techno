package org.example.tz.service;

import org.example.tz.dto.CurrencyRequest;
import org.example.tz.dto.CurrencyResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {
    private final RestTemplate restTemplate = new RestTemplate();

    public CurrencyResponse convert(CurrencyRequest request) {
        String url = String.format("https://api.exchangerate.host/convert?from=%s&to=%s&amount=%f",
                request.getFrom(), request.getTo(), request.getAmount());
        Map response = restTemplate.getForObject(url, Map.class);
        CurrencyResponse result = new CurrencyResponse();
        result.setFrom(request.getFrom());
        result.setTo(request.getTo());
        result.setAmount(request.getAmount());
        if (response != null && Boolean.TRUE.equals(response.get("success"))) {
            Map info = (Map) response.get("info");
            result.setRate(info != null ? ((Number) info.get("rate")).doubleValue() : 0.0);
            result.setResult(((Number) response.get("result")).doubleValue());
            result.setDate((String) response.get("date"));
        }
        return result;
    }
} 