package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Child;
import com.example.mindersplace.dtos.request.ChildRegistrationRequest;
import com.example.mindersplace.utils.ApiResponse;

public interface ChildService {
   Child save(ChildRegistrationRequest childRegistrationRequest);

}
