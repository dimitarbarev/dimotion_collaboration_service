package org.example.business;


import org.example.model.request.TeamRequest;
import org.example.model.response.TeamResponse;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    TeamResponse create(TeamRequest request);
    Optional<TeamResponse> getById(Long id);
    List<TeamResponse> getAll();
    void deleteById(Long id);
}
