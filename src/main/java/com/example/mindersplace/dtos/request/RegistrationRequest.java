package com.example.mindersplace.dtos.request;

import com.example.mindersplace.data.models.UserCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegistrationRequest {
    private String userName;
    private String emailAddress;
    private String password;
    private String lastName;
    private String firstName;
    private String postCode;
    private String city;
    private String address;
    private String userCategory;
    private String country;
    private String applicationCode;
    private String jobTitle;
    private String unitCity;
}
