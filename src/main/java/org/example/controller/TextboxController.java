package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.business.TextboxService;
import org.example.model.request.TextboxRequest;
import org.example.model.response.TextboxResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/private/textboxes")
@RequiredArgsConstructor
public class TextboxController {

    private final TextboxService textboxService;

    @PostMapping
    public ResponseEntity<TextboxResponse> create(@RequestBody TextboxRequest request) {
        return ResponseEntity.ok(textboxService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TextboxResponse> getById(@PathVariable Long id) {
        return textboxService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<TextboxResponse> getAll() {
        return textboxService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        textboxService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
