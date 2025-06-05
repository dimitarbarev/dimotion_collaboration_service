package org.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private/test")
public class TestController {

    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok(" Health check: The Collaboration Service is running.");
    }
}

