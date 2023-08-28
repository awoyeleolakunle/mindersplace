package com.example.mindersplace.services.otpService;


import com.example.mindersplace.data.models.VerificationToken;
import com.example.mindersplace.services.VerificationTokenService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SendOtpServiceImpl  implements SendOtpService{

    private final VerificationTokenService verificationTokenService;

    private final JavaMailSender mailSender;

    @Override
    public ApiResponse sendOtp(String emailAddress) {

        String generatedOtp = verificationTokenService.generateVerificationToken(3);
        VerificationToken verificationToken = VerificationToken.builder()
                .verificationToken(generatedOtp)
                .createdAt(LocalDateTime.now())
                .expiredAt(LocalDateTime.now().plusMinutes(15L))
                .emailAddress(emailAddress)
                .build();

        verificationTokenService.save(verificationToken);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("awoyeleolakunle@gmail.com");
        simpleMailMessage.setTo(emailAddress);
        simpleMailMessage.setSubject(GenerateApiResponse.VERIFY_THAT_ITS_YOU);
        simpleMailMessage.setText( "Kindly verify your account with this Otp code %n %n" + verificationToken.getVerificationToken());
        System.out.println("I got here");
        mailSender.send(simpleMailMessage);

        return ApiResponse.builder()
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();
    }

}
