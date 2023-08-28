package com.example.mindersplace.controller.otpController;


import com.example.mindersplace.services.VerificationTokenService;
import com.example.mindersplace.services.otpService.SendOtpService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/")
@AllArgsConstructor
public class SendOtpController {

    private final SendOtpService sendOtpService;

    @PostMapping("sendOtp")
    public ResponseEntity<ApiResponse> sendOtp(@RequestParam String emailAddress){
        return new ResponseEntity<>(sendOtpService.sendOtp(emailAddress), HttpStatus.OK);
    }
}
