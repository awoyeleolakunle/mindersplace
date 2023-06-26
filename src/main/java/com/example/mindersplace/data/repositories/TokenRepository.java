package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findTokenByUserEmailAddress(String userEmailAddress);
    Optional<Token> findTokensByJwt(String jwt);
}
