package com.example.mindersplace.services.profileUpdate.minderProfileUpdate;

import com.example.mindersplace.dtos.request.MinderProfileUpdateRequest;
import com.example.mindersplace.utils.ApiResponse;

public interface MinderProfileService {

    ApiResponse updateMinderProfileDetails(String emailAddress, MinderProfileUpdateRequest minderProfileUpdateRequest);
}
