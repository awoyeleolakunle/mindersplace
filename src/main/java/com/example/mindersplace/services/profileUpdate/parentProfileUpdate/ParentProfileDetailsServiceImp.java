package com.example.mindersplace.services.profileUpdate.parentProfileUpdate;

import com.example.mindersplace.data.models.User;
import com.example.mindersplace.services.UserService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParentProfileDetailsServiceImp implements ParentProfileDetailsService{

    private final UserService userService;

    @Override
    public ApiResponse loadParentProfileDetails(String emailAddress) {
        if(!isVerified(emailAddress)){
            return ApiResponse.builder()
                    .data(GenerateApiResponse.USER_NOT_FOUND)
                    .isSuccessful(false)
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .statusCode(HttpStatus.NO_CONTENT.value())
                    .build();
        }
        User foundUser = userService.findByEmailAddress(emailAddress);

        return ApiResponse.builder()
                .data(foundUser)
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .build();
    }
    private boolean isVerified(String emailAddress){
        User verifiedUser =  userService.findByEmailAddress(emailAddress);
        return verifiedUser!=null;
    }
}


