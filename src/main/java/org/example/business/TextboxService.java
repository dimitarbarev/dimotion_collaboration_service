package org.example.business;
import org.example.model.request.TextboxRequest;
import org.example.model.response.TextBoxResponse;
import org.example.model.response.TextBoxResponse;

import java.util.List;
import java.util.Optional;

public interface TextboxService {
    TextBoxResponse create(TextboxRequest request);
    Optional<TextBoxResponse> getById(Long id);
    List<TextBoxResponse> getAll();
    void deleteById(Long id);
}
