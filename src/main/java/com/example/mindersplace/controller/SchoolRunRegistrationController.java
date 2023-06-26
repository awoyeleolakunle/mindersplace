package com.example.mindersplace.controller;


import com.example.mindersplace.dtos.request.SchoolRunRegistrationRequest;
import com.example.mindersplace.services.SchoolRunRegistrationService;
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
public class SchoolRunRegistrationController {

    private final SchoolRunRegistrationService schoolRunRegisterService;

    @PostMapping("registerSchoolRun")
    public ResponseEntity<ApiResponse> registerSchoolRun( @RequestBody @Valid SchoolRunRegistrationRequest request){
        ApiResponse registerResponse = schoolRunRegisterService.registerSchoolRun(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }

}
