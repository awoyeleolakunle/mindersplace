package com.example.mindersplace.controller;

import com.example.mindersplace.dtos.request.HomeChildCareRegistrationRequest;
import com.example.mindersplace.services.homeChildCare.HomeChildCareRegistrationService;
import com.example.mindersplace.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class HomeChildCareRegistrationController {
    private final HomeChildCareRegistrationService homeChildCareRegistrationService;

    @PostMapping("registerHomeChildCare")
    public ResponseEntity<ApiResponse> registerHomeChildCare( @RequestBody @Valid HomeChildCareRegistrationRequest registrationRequest){
        ApiResponse registrationResponse = homeChildCareRegistrationService.registerHomeChildCare(registrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
    }
}
