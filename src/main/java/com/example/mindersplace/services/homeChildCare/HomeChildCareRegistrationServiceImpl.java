package com.example.mindersplace.services.homeChildCare;

import com.example.mindersplace.data.models.ClassType;
import com.example.mindersplace.data.models.HomeChildCareRegistration;
import com.example.mindersplace.data.repositories.HomeChildCareRepository;
import com.example.mindersplace.dtos.request.HomeChildCareRegistrationRequest;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HomeChildCareRegistrationServiceImpl implements HomeChildCareRegistrationService {

    private final HomeChildCareRepository homeChildCareRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse registerHomeChildCare(HomeChildCareRegistrationRequest homeChildCareRegistrationRequest) {
        HomeChildCareRegistration registration  =
                modelMapper.map(homeChildCareRegistrationRequest, HomeChildCareRegistration.class);
        registration.setClassType(ClassType.valueOf(homeChildCareRegistrationRequest.getClassType().toUpperCase()));
         homeChildCareRepository.save(registration);

        return GenerateApiResponse.createdResponse(GenerateApiResponse.HOME_CHILD_CARE_REGISTRATION_SUCCESSFUL);
    }
}
