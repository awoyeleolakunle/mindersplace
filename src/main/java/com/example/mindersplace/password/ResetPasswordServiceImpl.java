package com.example.mindersplace.password;

import com.example.mindersplace.data.models.User;
import com.example.mindersplace.services.UserService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResetPasswordServiceImpl  implements ResetPasswordService{
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public ApiResponse resetPassword(ResetPasswordRequest resetPasswordRequest) {
        boolean isRegisterd = userService.findByEmailAddress(resetPasswordRequest.getEmailAddress())!=null;
        if(isRegisterd){
            String password = passwordEncoder.encode(resetPasswordRequest.getPassword());
            User foundUser = userService.findByEmailAddress(resetPasswordRequest.getEmailAddress());
            foundUser.setPassword(password);
            userService.saveUser(foundUser);
            return GenerateApiResponse.okResponse(GenerateApiResponse.PASSWORD_RESET_SUCCESSFULLY);
        }
        return GenerateApiResponse.notOkResponse(GenerateApiResponse.INVALID_CREDENTIALS);
    }
}
