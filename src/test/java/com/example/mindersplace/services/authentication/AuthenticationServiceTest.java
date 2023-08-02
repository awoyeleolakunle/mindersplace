package com.example.mindersplace.services.authentication;

import com.example.mindersplace.data.models.User;
import com.example.mindersplace.data.models.UserCategory;
import com.example.mindersplace.dtos.request.RegistrationRequest;
import com.example.mindersplace.services.UserService;
import com.example.mindersplace.services.VerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AuthenticationServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private VerificationTokenService verificationTokenService;
    @Autowired
    private AuthenticationService authenticationService;


    @Test
    void testThatAUserCanRegisterAndGetEmailVerified(){

        RegistrationRequest registrationRequest= new RegistrationRequest();
        registrationRequest.setUserCategory("PARENT");
        registrationRequest.setEmailAddress("awoyeleolakunle@gmail.com");
        registrationRequest.setFirstName("Olakunle");
        registrationRequest.setPassword("password");

      var response =   authenticationService.Register(registrationRequest);
      log.info("hello there {}", response.getData());

        assertThat(response.isSuccessful()).isTrue();
    }
}