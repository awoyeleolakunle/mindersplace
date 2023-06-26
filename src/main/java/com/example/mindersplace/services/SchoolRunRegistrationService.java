package com.example.mindersplace.services;

import com.example.mindersplace.dtos.request.SchoolRunRegistrationRequest;
import com.example.mindersplace.utils.ApiResponse;


public interface SchoolRunRegistrationService {
    ApiResponse registerSchoolRun(SchoolRunRegistrationRequest schoolRunRegisterRequest);
}
