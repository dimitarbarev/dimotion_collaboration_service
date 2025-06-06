package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.business.BoardService;
import org.example.model.request.BoardRequest;
import org.example.model.response.BoardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/private/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponse> create(@RequestBody BoardRequest request) {
        return ResponseEntity.ok(boardService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getById(@PathVariable Long id) {
        System.out.println("Trigger the retrieval of a board with id: " + id);
        return boardService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<BoardResponse> getAll() {
        System.out.println("Here ar ethe boards passed to the front end:");
        System.out.println(boardService.getAll());
        return boardService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
