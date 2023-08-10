package com.example.mindersplace.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUpdateRequest {
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String address;
    private String zipCode;
    private String phoneNumber;
}
