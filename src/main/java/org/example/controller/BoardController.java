package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.business.BoardService;
import org.example.business.TeamService;
import org.example.model.response.BoardResponse;
import org.example.model.response.TeamResponse;
import org.example.model.request.BoardRequest;
import org.example.security.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/private/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<BoardResponse> create(@RequestBody BoardRequest request) {
        return ResponseEntity.ok(boardService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getById(@PathVariable Long id) {
        System.out.println("Trigger the retrieval of a board with id: " + id);

        BoardResponse board = boardService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found"));

        String currentUserId = SecurityUtils.getCurrentUserId();

        TeamResponse team = teamService.getById(board.getTeamId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found"));

        boolean isMember = team.getUsers().stream()
                .anyMatch(u -> u.getId().equals(Long.valueOf(currentUserId)));

        if (!isMember) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not a member of this board's team");
        }

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
