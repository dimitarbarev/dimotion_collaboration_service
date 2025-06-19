package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.repository.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByEmail(String email);
}
