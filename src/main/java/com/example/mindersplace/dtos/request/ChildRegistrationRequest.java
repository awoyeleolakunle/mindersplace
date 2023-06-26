package com.example.mindersplace.dtos.request;

import com.example.mindersplace.data.models.Gender;
import com.example.mindersplace.data.models.Parent;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChildRegistrationRequest {
    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String country;
    private Parent parent;

}
