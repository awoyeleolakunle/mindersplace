package com.example.mindersplace.services.profileUpdate.parentProfileUpdate;


import com.example.mindersplace.data.models.Parent;
import com.example.mindersplace.data.models.User;
import com.example.mindersplace.dtos.request.ProfileUpdateRequest;
import com.example.mindersplace.services.ParentService;
import com.example.mindersplace.services.UserService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParentProfileServiceImp implements ParentProfileService {

    private final UserService userService;

    @Override
    public ApiResponse updateParentProfileDetails(ProfileUpdateRequest profileUpdateRequest, String emailAddress) {
        if(!isVerified(emailAddress)){
            return ApiResponse.builder()
                    .data(GenerateApiResponse.USER_NOT_FOUND)
                    .isSuccessful(false)
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .statusCode(HttpStatus.NO_CONTENT.value())
                    .build();
        }
         User updatedUser = makeUpdate(profileUpdateRequest, emailAddress);
        return ApiResponse.builder()
                .data(updatedUser)
                .isSuccessful(true)
                .httpStatus(HttpStatus.OK)
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    private boolean isVerified(String emailAddress){
        User verifiedUser =  userService.findByEmailAddress(emailAddress);
        return verifiedUser!=null;
    }
    private User makeUpdate(ProfileUpdateRequest profileUpdateRequest, String emailAddress){
        User foundUser = userService.findByEmailAddress(emailAddress);
        if(profileUpdateRequest.getCity()!=null){
        foundUser.setCity(profileUpdateRequest.getCity());}
        if(profileUpdateRequest.getFirstName()!=null){
        foundUser.setFirstName(profileUpdateRequest.getFirstName());}
        if(profileUpdateRequest.getZipCode()!=null){
        foundUser.setPostCode(profileUpdateRequest.getZipCode());}
        if(profileUpdateRequest.getLastName()!=null){
        foundUser.setLastName(profileUpdateRequest.getLastName());}
        if(profileUpdateRequest.getAddress()!=null){
        foundUser.setAddress(profileUpdateRequest.getAddress());}
        if(profileUpdateRequest.getCountry()!=null){
        foundUser.setCountry(profileUpdateRequest.getCountry());}
        if(profileUpdateRequest.getPhoneNumber()!=null){
            foundUser.setPhoneNumber(profileUpdateRequest.getPhoneNumber());
        }
        return userService.saveUser(foundUser);
    }
}
