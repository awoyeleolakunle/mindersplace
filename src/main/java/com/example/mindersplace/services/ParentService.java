package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Child;
import com.example.mindersplace.data.models.Parent;
import com.example.mindersplace.dtos.request.ChildRegistrationRequest;
import com.example.mindersplace.utils.ApiResponse;

import java.util.List;

public interface ParentService {
    Parent saveParent(Parent parent);

    ApiResponse addAChild(String parentEmailAddress, ChildRegistrationRequest childRegistrationRequest);
    Parent findByUserEmailAddress(String emailAddress);

    List<Child> findAllChild(String parentEmailAddress);
}
