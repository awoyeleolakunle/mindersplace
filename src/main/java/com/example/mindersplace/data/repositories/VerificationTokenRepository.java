package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    Optional<VerificationToken> findByVerificationToken(String token);
}

