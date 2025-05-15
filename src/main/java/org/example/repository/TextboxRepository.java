package org.example.repository;

import org.example.repository.entity.TextboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextboxRepository extends JpaRepository<TextboxEntity, Long> {
    List<TextboxEntity> findByBoardId(Long boardId);
    List<TextboxEntity> findByUserId(Long userId);
}
