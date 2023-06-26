package com.example.mindersplace.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SchoolRunRegistrationRequest {
    private String name;
    private String emailAddress;
    private String classType;
    private String message;
}
