package org.example.business.implementation;

import lombok.RequiredArgsConstructor;
import org.example.business.TeamService;
import org.example.model.request.TeamRequest;
import org.example.model.response.TeamResponse;
import org.example.model.response.UserResponse;
import org.example.repository.TeamRepository;
import org.example.repository.UserRepository;
import org.example.repository.entity.TeamEntity;
import org.example.repository.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImplementation implements TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    @Override
    public TeamResponse create(TeamRequest request) {
        Set<UserEntity> users = new HashSet<>(userRepository.findAllById(request.getUserIds()));

        TeamEntity team = TeamEntity.builder()
                .name(request.getName())
                .users(users)
                .build();

        TeamEntity saved = teamRepository.save(team);

        return TeamResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .users(users.stream()
                        .map(user -> UserResponse.builder()
                                .id(user.getId())
                                .name(user.getName())
                                .email(user.getEmail())
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }

    @Override
    public Optional<TeamResponse> getById(Long id) {
        return teamRepository.findById(id).map(team ->
                TeamResponse.builder()
                        .id(team.getId())
                        .name(team.getName())
                        .users(team.getUsers().stream()
                                .map(user -> UserResponse.builder()
                                        .id(user.getId())
                                        .name(user.getName())
                                        .email(user.getEmail())
                                        .build())
                                .collect(Collectors.toSet()))
                        .build());
    }

    @Override
    public List<TeamResponse> getAll() {
        return teamRepository.findAll().stream()
                .map(team -> getById(team.getId()).orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }
}
