package com.example.mindersplace.services.profileUpdate.minderProfileUpdate;

import com.example.mindersplace.data.models.Minder;
import com.example.mindersplace.data.models.User;
import com.example.mindersplace.dtos.request.MinderProfileUpdateRequest;
import com.example.mindersplace.services.MinderService;
import com.example.mindersplace.services.UserService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class MinderProfileServiceImpl implements MinderProfileService{

    private final MinderService minderService;
    private final UserService userService;
    @Override
    public ApiResponse updateMinderProfileDetails(String emailAddress, MinderProfileUpdateRequest minderProfileUpdateRequest) {

        System.out.println("yes yes ");
        if (!isVerifiedMinder(emailAddress)) {
            return ApiResponse.builder()
                    .data(GenerateApiResponse.USER_NOT_FOUND)
                    .isSuccessful(false)
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build();
        }

        Minder updatedProfile = makeUpdate(emailAddress, minderProfileUpdateRequest);
        System.out.println(updatedProfile.getUser().getUserName());
           // Minder minder =
            return ApiResponse.builder()
                    .data(updatedProfile)
                    .isSuccessful(true)
                    .httpStatus(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build();

    }
    private boolean isVerifiedMinder(String emailAddress){
        Minder minder = minderService.findByEmailAddress(emailAddress);
        return minder!=null;
    }


    private Minder makeUpdate(String emailAddress, MinderProfileUpdateRequest minderProfileUpdateRequest){
        System.out.println("i entered here");
        Minder minder = minderService.findByEmailAddress(emailAddress);
        System.out.println("Im the minder, i am found ooo" + minder);
        User foundUser = userService.findByEmailAddress(emailAddress);
        if(minderProfileUpdateRequest.getPhoneNumber()!=null){
        foundUser.setPhoneNumber(minderProfileUpdateRequest.getPhoneNumber());}
        if(minderProfileUpdateRequest.getFirstName()!=null){
            foundUser.setFirstName(minderProfileUpdateRequest.getFirstName());
        }
        if(minderProfileUpdateRequest.getDateOfBirth()!=null){
            foundUser.setDateOfBirth(minderProfileUpdateRequest.getDateOfBirth());
        }
        if(minderProfileUpdateRequest.getCountry()!=null){
            foundUser.setCountry(minderProfileUpdateRequest.getCountry());
        }
        User savedUser = userService.saveUser(foundUser);
        System.out.println(savedUser.getFirstName());
        minder.setUser(savedUser);
        if(minderProfileUpdateRequest.getPersonalIdNumber()!=null){
        minder.setPersonalIdNumber(minderProfileUpdateRequest.getPersonalIdNumber());}

        System.out.println("this is where I was set" + minderProfileUpdateRequest.getPhoneNumber());

        Minder updatedMinder = minderService.saveMinder(minder);
        System.out.println("I'm the personal Id " + updatedMinder.getPersonalIdNumber());


        System.out.println(updatedMinder.getPersonalIdNumber());
        return updatedMinder;
    }

}
