package org.example.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.security.EncryptionUtil;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserEntity {
    @Id
    @Column(nullable = false, unique = true)
    private String id; // this holds Auth0's sub

    private String name;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "user_team",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<TeamEntity> teams;

    @ManyToMany
    @JoinTable(
            name = "user_board",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "board_id")
    )
    private Set<BoardEntity> boards;

    public String getEmail() {
        return EncryptionUtil.decrypt(this.email);
    }

    public void setEmail(String email) {
        this.email = EncryptionUtil.encrypt(email);
    }
}

