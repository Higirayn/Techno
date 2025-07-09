package org.example.tz.controller;

import org.example.tz.dto.CurrencyRequest;
import org.example.tz.dto.CurrencyResponse;
import org.example.tz.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @PostMapping
    public CurrencyResponse convert(@RequestBody CurrencyRequest request) {
        return currencyService.convert(request);
    }
} 