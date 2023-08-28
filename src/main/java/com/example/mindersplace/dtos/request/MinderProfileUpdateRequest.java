package com.example.mindersplace.dtos.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MinderProfileUpdateRequest {
    private String firstName;
    private String lastName;
    private String personalIdNumber;
    private String dateOfBirth;
    private String PhoneNumber;
    private String country;
}
