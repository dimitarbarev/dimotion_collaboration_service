package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.business.TeamService;
import org.example.model.request.TeamRequest;
import org.example.model.response.TeamResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<TeamResponse> create(@RequestBody TeamRequest request) {
        return ResponseEntity.ok(teamService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> getById(@PathVariable Long id) {
        return teamService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<TeamResponse> getAll() {
        return teamService.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teamService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
