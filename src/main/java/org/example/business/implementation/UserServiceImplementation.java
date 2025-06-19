package org.example.business.implementation;

import lombok.RequiredArgsConstructor;
import org.example.business.MessagePublisher;
import org.example.business.UserService;
import org.example.model.request.UserRequest;
import org.example.model.response.UserResponse;
import org.example.repository.UserRepository;
import org.example.repository.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    private final MessagePublisher messagePublisher;

    @Override
    public UserResponse create(UserRequest request) {
        UserEntity user = UserEntity.builder()
                .id(request.getId())
                .name(request.getName())
                .build();
        // encryption is applied to the email
        user.setEmail(request.getEmail());

        UserEntity saved = userRepository.save(user);
        return UserResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .email(saved.getEmail())
                .build();
    }

    @Override
    public Optional<UserResponse> getById(String id) {
        return userRepository.findById(id)
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build());
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .toList();
    }

    @Override
    public void deleteById(String id) {
        System.out.println("Deletion is triggered in the service.");
        System.out.println("ID for deletion: " + id);
        userRepository.deleteById(id);
        messagePublisher.publishUserDeleted(id);
    }
}
