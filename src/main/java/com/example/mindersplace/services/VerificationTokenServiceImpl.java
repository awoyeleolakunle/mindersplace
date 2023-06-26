package com.example.mindersplace.services;

import com.example.mindersplace.data.models.VerificationToken;
import com.example.mindersplace.data.repositories.VerificationTokenRepository;
import com.example.mindersplace.exceptions.TokenNotFoundExemption;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VerificationTokenServiceImpl implements VerificationTokenService{

    private final VerificationTokenRepository verificationTokenRepository;

    @Override
    public void save(VerificationToken verificationToken) {
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public Optional<VerificationToken> getVerificationToken(String token) {
        return verificationTokenRepository.findByVerificationToken(token);

    }

    @Override
    public void confirmedAt(String token) throws TokenNotFoundExemption {
        VerificationToken verificationToken = new VerificationToken();
        if (isValidToken(token)){
            verificationToken.setConfirmedAt(LocalDateTime.now());
        }
        else{
            throw new TokenNotFoundExemption("Token not found");
        }
    }

    private boolean isValidToken(String token) {
        boolean isPresent = getVerificationToken(token).isPresent();
        if(isPresent) return true;
        return false;
    }
}
