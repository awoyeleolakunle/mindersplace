package com.example.mindersplace.controller.otpController;


import com.example.mindersplace.dtos.request.OtpConfirmationRequest;
import com.example.mindersplace.services.VerificationTokenService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*")
@AllArgsConstructor

public class ConfirmOtpController {
    private final VerificationTokenService verificationTokenService;

    @PostMapping("confirmOtp")
    public ResponseEntity<ApiResponse> confirmOtp(@RequestBody OtpConfirmationRequest otpConfirmationRequest){
        return new ResponseEntity<>(verificationTokenService.confirmToken(otpConfirmationRequest), HttpStatus.OK);
    }
}
