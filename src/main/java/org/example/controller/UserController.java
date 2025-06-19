package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.business.UserService;
import org.example.model.request.UserRequest;
import org.example.model.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/private/users")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable String id) {
        return userService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        System.out.println("Deletion is triggered in hte controller.");
        System.out.println("ID for deletion: " + id);
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
