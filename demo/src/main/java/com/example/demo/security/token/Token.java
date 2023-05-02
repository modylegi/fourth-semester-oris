package com.example.demo.security.token;

import com.example.demo.entities.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Data
@Builder
@Entity(name = "Token")
@Table(
        name = "token",
        uniqueConstraints = {
                @UniqueConstraint(name = "token_unique", columnNames = "token")
        }
)
@AllArgsConstructor
public class Token {

    @Id
    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "token_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    private String token;
    @Enumerated(EnumType.STRING)
    private TokenType type;
    private boolean expired;
    private boolean revoked;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
