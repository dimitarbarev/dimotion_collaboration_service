package org.example.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDateTime datetime;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private TeamEntity team;

    @ManyToMany(mappedBy = "boards")
    private Set<UserEntity> users;
}