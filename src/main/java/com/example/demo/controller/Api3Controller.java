package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate; 

@RestController
@RequestMapping("/api3")
public class Api3Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<Object> getApi3Data() {
        String api5Url = "https://api.restful-api.dev/objects/7";
        
        try {
            Object api5Response = restTemplate.getForObject(api5Url, Object.class);
            return ResponseEntity.ok(api5Response);
        } catch (RestClientException e) {
            String errorMessage = "Error calling API 5: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }
}