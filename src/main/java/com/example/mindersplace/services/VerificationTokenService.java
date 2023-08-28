package com.example.mindersplace.services;

import com.example.mindersplace.data.models.VerificationToken;
import com.example.mindersplace.dtos.request.OtpConfirmationRequest;
import com.example.mindersplace.exceptions.TokenNotFoundExemption;
import com.example.mindersplace.utils.ApiResponse;

import java.util.Optional;

public interface VerificationTokenService {
    void save(VerificationToken verificationToken);
    Optional<VerificationToken> getVerificationToken(String token);
    ApiResponse confirmToken(OtpConfirmationRequest otpConfirmationRequest);
    String generateVerificationToken(int length);

}
