package com.example.mindersplace.services.childService;

import com.example.mindersplace.data.models.Child;
import com.example.mindersplace.dtos.request.ChildRegistrationRequest;
import com.example.mindersplace.utils.ApiResponse;
import jakarta.transaction.Transactional;

public interface ChildService {
   Child save(ChildRegistrationRequest childRegistrationRequest);

   @Transactional
    Child merge(Child detachedChild);
}
