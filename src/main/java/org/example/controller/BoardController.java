package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.business.BoardService;
import org.example.model.response.BoardResponse;
import org.example.model.request.BoardRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/private/boards")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponse> create(@RequestBody BoardRequest request) {
        return ResponseEntity.ok(boardService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getById(@PathVariable Long id) {
        System.out.println("Trigger the retrieval of a board with id: " + id);

        BoardResponse board = boardService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found"));

        return ResponseEntity.ok(board);
    }

    @GetMapping
    public List<BoardResponse> getAll() {
        System.out.println("Here are the boards passed to the front end:");
        System.out.println(boardService.getAll());
        return boardService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
