package com.example.mindersplace.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String verificationToken;
    private LocalDateTime createdAt;
    private LocalDateTime confirmedAt;
    private LocalDateTime expiredAt;
    private String emailAddress;
//    @ManyToOne
//    private User user;

    public VerificationToken(String token, LocalDateTime plusMinutes, LocalDateTime now, String emailAddress) {
        this.verificationToken = token;
        this.expiredAt = plusMinutes;
        this.createdAt = now;
        this.emailAddress = emailAddress;

//        this.user = savedUser;
    }

}
