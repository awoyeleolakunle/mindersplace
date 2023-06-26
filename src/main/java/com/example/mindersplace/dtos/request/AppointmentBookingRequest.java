package com.example.mindersplace.dtos.request;

import jakarta.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentBookingRequest {
    @NotEmpty
    private String guardianName;
    @NotEmpty
    private String phoneNumber;
    @NotEmpty
    private String emailAddress;
    @NotEmpty
    private String childName;
    private int ageOfChild;
    @NotEmpty
    private String message;
}
