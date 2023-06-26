package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Token;

import java.util.Optional;

public interface TokenService {
    Token saveToken(Token token);
    Optional<Token> findTokenByUserEmailAddress(String emailAddress);
}
