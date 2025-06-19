package org.example.business.implementation;

import lombok.RequiredArgsConstructor;
import org.example.business.TextboxService;
import org.example.model.request.TextboxRequest;
import org.example.model.response.TextBoxResponse;
import org.example.repository.BoardRepository;
import org.example.repository.TextboxRepository;
import org.example.repository.UserRepository;
import org.example.repository.entity.BoardEntity;
import org.example.repository.entity.TextboxEntity;
import org.example.repository.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TextboxServiceImplementation implements TextboxService {

    private final TextboxRepository textboxRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Override
    public TextBoxResponse create(TextboxRequest request) {
        BoardEntity board = boardRepository.findById(request.getBoardId())
                .orElseThrow(() -> new RuntimeException("Board not found"));
        UserEntity user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        TextboxEntity textbox = TextboxEntity.builder()
                .board(board)
                .user(user)
                .build();

        TextboxEntity saved = textboxRepository.save(textbox);

        return TextBoxResponse.builder()
                .id(saved.getId())
                .boardId(saved.getBoard().getId())
                .userId(saved.getUser().getId())
                .build();
    }

    @Override
    public Optional<TextBoxResponse> getById(Long id) {
        return textboxRepository.findById(id).map(tb ->
                TextBoxResponse.builder()
                        .id(tb.getId())
                        .boardId(tb.getBoard().getId())
                        .userId(tb.getUser().getId())
                        .build());
    }

    @Override
    public List<TextBoxResponse> getAll() {
        return textboxRepository.findAll().stream()
                .map(tb -> TextBoxResponse.builder()
                        .id(tb.getId())
                        .boardId(tb.getBoard().getId())
                        .userId(tb.getUser().getId())
                        .build())
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        textboxRepository.deleteById(id);
    }
}