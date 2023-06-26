package com.example.mindersplace.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String guardianName;
    private String phoneNumber;
    private String emailAddress;
    private String childName;
    private int ageOfChild;
    private String message;
}


