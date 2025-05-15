package org.example.business;
import org.example.model.request.TextboxRequest;
import org.example.model.response.TextboxResponse;

import java.util.List;
import java.util.Optional;

public interface TextboxService {
    TextboxResponse create(TextboxRequest request);
    Optional<TextboxResponse> getById(Long id);
    List<TextboxResponse> getAll();
    void deleteById(Long id);
}
