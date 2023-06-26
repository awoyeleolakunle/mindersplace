package com.example.mindersplace.services;

import com.example.mindersplace.data.models.VerificationToken;
import com.example.mindersplace.exceptions.TokenNotFoundExemption;

import java.util.Optional;

public interface VerificationTokenService {
    void save(VerificationToken verificationToken);
    Optional<VerificationToken> getVerificationToken(String token);
    void confirmedAt(String token) throws TokenNotFoundExemption;
}
