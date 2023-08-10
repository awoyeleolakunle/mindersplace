package com.example.mindersplace.services.profileUpdate.parentProfileUpdate;

import com.example.mindersplace.data.models.User;
import com.example.mindersplace.data.models.UserCategory;
import com.example.mindersplace.dtos.request.ProfileUpdateRequest;
import com.example.mindersplace.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ParentProfileServiceImpTest {

    @Autowired
    private UserService userService;
    @Autowired
    private ParentProfileService parentProfileService;
    @Test
    public void testThatAUserCanUpdateProfile(){

        User user = new User();
        user.setLastName("firstName");
        user.setUserCategory(UserCategory.PARENT);
        user.setFirstName("firstName");
        user.setLastName("LastName");
        user.setCountry("Morocco");
        user.setEmailAddress("user@gmail.com");
        user.setPassword("12345");

        userService.saveUser(user);

        ProfileUpdateRequest profileUpdateRequest = new ProfileUpdateRequest();
       // profileUpdateRequest.setCountry("Nigeria");
        profileUpdateRequest.setFirstName("Lekan");
        profileUpdateRequest.setLastName("Mama Patience");

        var response1 =  parentProfileService.updateParentProfileDetails( profileUpdateRequest, "user@gmail.com");


        ProfileUpdateRequest profileUpdateRequest1 = new ProfileUpdateRequest();
       // profileUpdateRequest1.setCountry("Ghana");
        profileUpdateRequest1.setFirstName("Soji");
       var response =  parentProfileService.updateParentProfileDetails( profileUpdateRequest1, "user@gmail.com");
        System.out.println(response.getData().toString());
        assertThat(response.getData()).isNotNull();

        var foundUser = userService.findByEmailAddress("user@gmail.com");
        assertThat(foundUser.getCountry()).isEqualTo("Morocco");
        assertThat(foundUser.getEmailAddress()).isNotNull();
    }
}