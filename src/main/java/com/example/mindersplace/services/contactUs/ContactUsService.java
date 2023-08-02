package com.example.mindersplace.services.contactUs;

import com.example.mindersplace.dtos.request.ContactUsRequest;
import com.example.mindersplace.utils.ApiResponse;

public interface ContactUsService {
    ApiResponse contactUs(ContactUsRequest request);
}
