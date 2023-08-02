package com.example.mindersplace.services.homeChildCare;

import com.example.mindersplace.dtos.request.HomeChildCareRegistrationRequest;
import com.example.mindersplace.utils.ApiResponse;

public interface HomeChildCareRegistrationService {
    ApiResponse registerHomeChildCare(HomeChildCareRegistrationRequest homeChildCareRegistrationRequest);
}
