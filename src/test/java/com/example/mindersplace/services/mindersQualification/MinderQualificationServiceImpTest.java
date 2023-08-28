package com.example.mindersplace.services.mindersQualification;

import com.example.mindersplace.dtos.request.QualificationRequest;
import com.example.mindersplace.dtos.request.RegistrationRequest;
import com.example.mindersplace.services.MinderService;
import com.example.mindersplace.services.UserService;
import com.example.mindersplace.services.authentication.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.spi.RegisterableService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MinderQualificationServiceImpTest {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private MinderService minderService;
    @Autowired
    private MinderQualificationsService minderQualificationsService;


    @Test
    public void testThatAMinderCanSaveQualifications(){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUserCategory("MINDER");
        registrationRequest.setEmailAddress("emailAddress");
        registrationRequest.setPassword("12345");
        registrationRequest.setCity("Lagos");

        authenticationService.Register(registrationRequest);

        QualificationRequest qualificationRequest = new QualificationRequest();
        qualificationRequest.setCertificateNumber("12344566");
        qualificationRequest.setCertificateImgUrl("http://res.image/cloudinary/image.gorilla");

   var response =  minderQualificationsService.saveMinderQualifications("emailAddress", qualificationRequest);

    assertThat(response.isSuccessful()).isTrue();
    }
}


