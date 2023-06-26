package com.example.mindersplace.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeChildCareRegistrationRequest {

    private String name;
    private String emailAddress;
    private String classType;
    private String message;
}
