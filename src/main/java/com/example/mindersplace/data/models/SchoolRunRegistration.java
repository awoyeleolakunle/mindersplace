package com.example.mindersplace.data.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SchoolRunRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String emailAddress;
    @Enumerated(EnumType.STRING)
    private ClassType classType;
    private String message;

}
