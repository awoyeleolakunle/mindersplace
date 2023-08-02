package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Gender;
import com.example.mindersplace.data.models.Parent;
import com.example.mindersplace.data.models.User;
import com.example.mindersplace.data.models.UserCategory;
import com.example.mindersplace.dtos.request.ChildRegistrationRequest;
import com.example.mindersplace.dtos.request.RegistrationRequest;
import com.example.mindersplace.services.authentication.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.mindersplace.data.models.Gender.MALE;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest


class ParentServiceImplTest {
@Autowired

private ParentService parentService;

@Autowired
    private UserService userService;
@Autowired
private AuthenticationService authenticationService;


    @Test
    void testThatAParentCanAddAChild(){
        ChildRegistrationRequest request = new ChildRegistrationRequest();
        request.setFirstName("first");
        request.setLastName("lastname");
        request.setGender(MALE);
        request.setCountryOfBirth("Country");
        request.setMiddleName("middlename");
        User user = new User();
        user.setEmailAddress("emailAddess@gmail.com");
        user.setUserCategory(UserCategory.valueOf("PARENT"));
        userService.saveUser(user);
        Parent parent = new Parent();
        parent.setUser(user);
        parentService.saveParent(parent);
        parentService.addAChild("emailAddess@gmail.com", request);

        assertThat( parent.getChild()).isNotNull();
    }
    @Test
    void testListOfChildOfAParentCanBeFound(){
        ChildRegistrationRequest request = new ChildRegistrationRequest();
        request.setFirstName("first");
        request.setLastName("lastname");
        request.setGender(MALE);
        request.setCountryOfBirth("Country");
        request.setMiddleName("middlename");
        User user = new User();
        user.setEmailAddress("emailAddess@gmail.com");
        user.setUserCategory(UserCategory.valueOf("PARENT"));
        userService.saveUser(user);
        Parent parent = new Parent();
        parent.setUser(user);
        parentService.saveParent(parent);
        parentService.addAChild("emailAddess@gmail.com", request);



        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setUserCategory("PARENT");
        registrationRequest.setEmailAddress("parentmail@gmail.com");
        registrationRequest.setPassword("password");

        authenticationService.Register(registrationRequest);
        ChildRegistrationRequest childRegistrationRequest = new ChildRegistrationRequest();
        childRegistrationRequest.setGender(Gender.valueOf("FEMALE"));
        childRegistrationRequest.setFirstName("Moore");
        childRegistrationRequest.setLastName("lastname");

        ChildRegistrationRequest childRegistrationRequest1 = new ChildRegistrationRequest();
        childRegistrationRequest1.setGender(Gender.valueOf("MALE"));
        childRegistrationRequest1.setFirstName("Sam Owolabi");
        childRegistrationRequest1.setLastName("lastChild");
        parentService.addAChild(registrationRequest.getEmailAddress(), childRegistrationRequest);
        parentService.addAChild(registrationRequest.getEmailAddress(), childRegistrationRequest1);
        var response = parentService.findAllChild(registrationRequest.getEmailAddress());

        assertThat(response.size()).isEqualTo(2);
    }


}