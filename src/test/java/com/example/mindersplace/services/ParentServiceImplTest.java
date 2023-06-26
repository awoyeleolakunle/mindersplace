package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Parent;
import com.example.mindersplace.data.models.User;
import com.example.mindersplace.data.models.UserCategory;
import com.example.mindersplace.dtos.request.ChildRegistrationRequest;
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


    @Test
    void testThatAParentCanAddAChild(){
        ChildRegistrationRequest request = new ChildRegistrationRequest();
        request.setFirstName("first");
        request.setLastName("lastname");
        request.setGender(MALE);
        request.setCountry("Country");
        request.setMiddleName("middlename");
        User user = new User();
        user.setEmailAddress("emailAddess@gmail.com");
        user.setUserCategory(UserCategory.valueOf("PARENT"));
        userService.saveUser(user);
        Parent parent = new Parent();
        parent.setUser(user);
        parentService.registerParent(parent);
        parentService.addAChild("emailAddess@gmail.com", request);


        assertThat( parent.getChild()).isNotNull();
    }

}