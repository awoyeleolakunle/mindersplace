package com.example.mindersplace.services.mindersQualification;

import com.example.mindersplace.dtos.request.QualificationRequest;
import com.example.mindersplace.utils.ApiResponse;

public interface MinderQualificationsService {
    ApiResponse saveMinderQualifications(String minderEmailAddress, QualificationRequest qualificationRequest);
}
