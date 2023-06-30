package com.example.mindersplace.password;

import com.example.mindersplace.utils.ApiResponse;

public interface ChangeForgotPasswordService {

    ApiResponse sendResetPasswordLink(String emailAddress);
}
