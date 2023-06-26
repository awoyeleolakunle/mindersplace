package com.example.mindersplace.controller;

import com.example.mindersplace.dtos.request.LoginRequest;
import com.example.mindersplace.dtos.request.RegistrationRequest;
import com.example.mindersplace.services.AuthenticationService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/auth/")
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("register")
    public ResponseEntity<ApiResponse> register(@RequestBody RegistrationRequest registrationRequest){
        return new ResponseEntity<>(authenticationService.Register(registrationRequest), HttpStatus.CREATED);
    }
    @PostMapping("login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest loginRequest){
        return new ResponseEntity<>(authenticationService.login(loginRequest), HttpStatus.OK);
    }

    @GetMapping("value")
    public String getValue(){
        return "Successful";
    }
}
