package com.example.mindersplace.controller;

import com.example.mindersplace.dtos.request.ContactUsRequest;
import com.example.mindersplace.services.ContactUsService;
import com.example.mindersplace.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ContactUsController {

    private final ContactUsService contactUsService;

    @PostMapping("contactUs")
    public ResponseEntity<ApiResponse> contactUS(@RequestBody @Valid ContactUsRequest contactUsRequest) {
        ApiResponse foundResponse = contactUsService.contactUs(contactUsRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(foundResponse);
    }

}
