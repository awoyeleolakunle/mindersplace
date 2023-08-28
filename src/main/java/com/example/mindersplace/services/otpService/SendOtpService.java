package com.example.mindersplace.services.otpService;

import com.example.mindersplace.utils.ApiResponse;

public interface SendOtpService {
    ApiResponse sendOtp(String emailAddress);
}
