package com.example.mindersplace.data.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String verificationToken;
    private LocalDateTime createdAt;
    private LocalDateTime confirmedAt;
    private LocalDateTime expiredAt;
//    @ManyToOne
//    private User user;

    public VerificationToken(String token, LocalDateTime plusMinutes, LocalDateTime now) {
        this.verificationToken = token;
        this.expiredAt = plusMinutes;
        this.createdAt = now;
//        this.user = savedUser;
    }

}
