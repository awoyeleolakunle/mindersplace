package com.example.mindersplace.password;

import com.example.mindersplace.utils.ApiResponse;

public interface ResetPasswordService {
    ApiResponse resetPassword(ResetPasswordRequest resetPasswordRequest);
}
