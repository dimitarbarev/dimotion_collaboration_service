package org.example.business;

import org.example.model.request.BoardRequest;
import org.example.model.response.BoardResponse;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    BoardResponse create(BoardRequest request);
    Optional<BoardResponse> getById(Long id);
    List<BoardResponse> getAll();
    void deleteById(Long id);
}
