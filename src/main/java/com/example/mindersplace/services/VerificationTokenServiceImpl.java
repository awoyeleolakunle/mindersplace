package com.example.mindersplace.services;

import com.example.mindersplace.data.models.VerificationToken;
import com.example.mindersplace.data.repositories.VerificationTokenRepository;
import com.example.mindersplace.dtos.request.OtpConfirmationRequest;
import com.example.mindersplace.exceptions.TokenNotFoundExemption;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;
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
    public ApiResponse confirmToken(OtpConfirmationRequest otpConfirmationRequest){
        if (isValidToken(otpConfirmationRequest.getToken(), otpConfirmationRequest.getEmailAddress())){
            System.out.println("i got in here");
            return ApiResponse.builder()
                    .data(GenerateApiResponse.VERIFICATION_SUCCESSFUL)
                    .isSuccessful(true)
                    .statusCode(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .build();
        }
        return ApiResponse.builder()
                .data(GenerateApiResponse.INVALID_CREDENTIALS)
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build();
    }

    @Override
    public String generateVerificationToken(int length) {
        byte [] bytes = new byte[length];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(bytes);
            }

    private boolean isValidToken(String token, String emailAddress) {

        Optional<VerificationToken> foundToken = getVerificationToken(token);
        if(foundToken.isPresent()){
            String email = foundToken.get().getEmailAddress();
            System.out.println("i'm inside");
            return email.equals(emailAddress);

        }
        return false;
    }



     @Scheduled(cron = "0 */10 * * * *")
    private void cronOtpOperation(){
        List<VerificationToken> allToken = verificationTokenRepository.findAll();
        allToken.stream().filter(verificationToken -> verificationToken.getExpiredAt().isBefore(LocalDateTime.now())).
                forEach(verificationTokenRepository::delete);
     }
}
