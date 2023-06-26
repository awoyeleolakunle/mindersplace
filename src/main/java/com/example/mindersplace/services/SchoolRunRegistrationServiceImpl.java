package com.example.mindersplace.services;

import com.example.mindersplace.data.models.ClassType;
import com.example.mindersplace.data.models.SchoolRunRegistration;
import com.example.mindersplace.data.repositories.SchoolRunRegistrationRepository;
import com.example.mindersplace.dtos.request.SchoolRunRegistrationRequest;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SchoolRunRegistrationServiceImpl implements SchoolRunRegistrationService {
    private final SchoolRunRegistrationRepository schoolRunRegistrationRepository;
    private final ModelMapper modelMapper;


    @Override
    public ApiResponse registerSchoolRun(SchoolRunRegistrationRequest schoolRunRegistrationRequest) {
        SchoolRunRegistration schoolRunRegistration = modelMapper.map(schoolRunRegistrationRequest, SchoolRunRegistration.class);
        schoolRunRegistration.setClassType(ClassType.valueOf(schoolRunRegistrationRequest.getClassType().toUpperCase()));
        schoolRunRegistrationRepository.save(schoolRunRegistration);
        return GenerateApiResponse.createdResponse(GenerateApiResponse.SCHOOL_RUN_REGISTRATION_SUCCESSFUL);
    }
}
