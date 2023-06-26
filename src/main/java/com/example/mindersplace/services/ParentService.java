package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Parent;
import com.example.mindersplace.dtos.request.ChildRegistrationRequest;
import com.example.mindersplace.dtos.request.RegistrationRequest;
import com.example.mindersplace.utils.ApiResponse;

public interface ParentService {
    Parent registerParent(Parent parent);

    ApiResponse addAChild(String parentEmailAddress, ChildRegistrationRequest childRegistrationRequest);
}
