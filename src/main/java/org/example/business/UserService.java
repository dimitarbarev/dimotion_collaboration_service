package org.example.business;

import org.example.model.request.UserRequest;
import org.example.model.response.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse create(UserRequest request);
    Optional<UserResponse> getById(String id);
    List<UserResponse> getAll();
    void deleteById(String id);
}
