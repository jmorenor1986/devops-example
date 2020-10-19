package com.example.microservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ping")
public class PingController {

    @GetMapping("/")
    public ResponseEntity<String> getPing() {
        return new ResponseEntity<>("Service is available", HttpStatus.OK);
    }
}
