package org.example.business.implementation;

import lombok.RequiredArgsConstructor;
import org.example.business.BoardService;
import org.example.business.MessagePublisher;
import org.example.model.request.BoardRequest;
import org.example.model.response.BoardResponse;
import org.example.repository.BoardRepository;
import org.example.repository.TeamRepository;
import org.example.repository.entity.BoardEntity;
import org.example.repository.entity.TeamEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImplementation implements BoardService {

    private final BoardRepository boardRepository;
    private final TeamRepository teamRepository;

    private final MessagePublisher messagePublisher;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public BoardResponse create(BoardRequest request) {
        TeamEntity team = teamRepository.findById(request.getTeamId())
                .orElseThrow(() -> new RuntimeException("Team not found"));

        BoardEntity board = BoardEntity.builder()
                .title(request.getTitle())
                .datetime(LocalDateTime.parse(request.getDatetime()))
                .team(team)
                .build();

        BoardEntity saved = boardRepository.save(board);

        return BoardResponse.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .datetime(saved.getDatetime().format(formatter))
                .teamId(saved.getTeam().getId())
                .build();
    }

    @Override
    public Optional<BoardResponse> getById(Long id) {
        return boardRepository.findById(id)
                .map(board -> BoardResponse.builder()
                        .id(board.getId())
                        .title(board.getTitle())
                        .datetime(board.getDatetime().format(formatter))
                        .teamId(board.getTeam().getId())
                        .build());
    }

    @Override
    public List<BoardResponse> getAll() {
        return boardRepository.findAll().stream()
                .map(board -> getById(board.getId()).orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
        System.out.println("Board Service Impl board delete event for ID: " + id);
        messagePublisher.publishBoardDeleted(id);
    }
}
