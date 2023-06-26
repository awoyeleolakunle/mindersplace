package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Token;
import com.example.mindersplace.data.repositories.TokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenServiceImpl implements TokenService{
    private final TokenRepository tokenRepository;

    @Override
    public Token saveToken(Token token) {
       Token savedToken = tokenRepository.save(token);
       return savedToken;
    }

    @Override
    public Optional<Token> findTokenByUserEmailAddress(String emailAddress) {
       return tokenRepository.findTokenByUserEmailAddress(emailAddress);
    }
}
