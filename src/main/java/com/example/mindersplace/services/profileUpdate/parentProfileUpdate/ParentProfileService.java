package com.example.mindersplace.services.profileUpdate.parentProfileUpdate;


import com.example.mindersplace.dtos.request.ProfileUpdateRequest;
import com.example.mindersplace.utils.ApiResponse;


public interface ParentProfileService {

    ApiResponse updateParentProfileDetails(ProfileUpdateRequest profileUpdateRequest, String emailAddress);
}
