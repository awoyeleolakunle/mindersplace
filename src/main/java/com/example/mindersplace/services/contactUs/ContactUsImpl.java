package com.example.mindersplace.services.contactUs;

import com.example.mindersplace.data.models.ContactUs;
import com.example.mindersplace.data.repositories.ContactUsRepository;
import com.example.mindersplace.dtos.request.ContactUsRequest;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactUsImpl implements ContactUsService{

    private final ContactUsRepository contactUsRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse contactUs(ContactUsRequest contactUsRequest) {
        ContactUs newContactUsDetails = modelMapper.map(contactUsRequest, ContactUs.class);
        contactUsRepository.save(newContactUsDetails);
        return GenerateApiResponse.createdResponse(GenerateApiResponse.CONTACT_MESSAGE_RECEIVED_SUCCESSFULLY);
    }
}
