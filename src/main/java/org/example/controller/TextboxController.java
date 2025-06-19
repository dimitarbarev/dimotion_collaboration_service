package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.business.TextboxService;
import org.example.model.request.TextboxRequest;
import org.example.model.response.TextBoxResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/private/textboxes")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class TextboxController {

    private final TextboxService textboxService;

    @PostMapping
    public ResponseEntity<TextBoxResponse> create(@RequestBody TextboxRequest request) {
        return ResponseEntity.ok(textboxService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TextBoxResponse> getById(@PathVariable Long id) {
        return textboxService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<TextBoxResponse> getAll() {
        return textboxService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        textboxService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
