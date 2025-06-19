package org.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/private/test")
    public ResponseEntity<String> healthCheckPrivate() {
        return ResponseEntity.ok(" Health check: The Collaboration Service is running.");
    }

    @GetMapping("/public/test")
    public ResponseEntity<String> healthCheckPublic() {
        return ResponseEntity.ok(" Health check: The Collaboration Service is running.");
    }

    @GetMapping("/public/isUpdated")
    public ResponseEntity<String> updatedCheck() {
        return ResponseEntity.ok(" The Collaboration service was updated 2.");
    }
}

