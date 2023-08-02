package com.example.mindersplace.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String emailAddress;
    private String password;
    private String lastName;
    private String firstName;
    private String postCode;
    private String city;
    private String address;
    private String phoneNumber;
    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role")
           // joinColumns = @JoinColumn(name = "user_id"))
    private Set<Roles> roles;
    @Enumerated(EnumType.STRING)
    private UserCategory userCategory;
   // @Column(name = "credit_Id")
   // @PrimaryKeyJoinColumn(name = "credit_card_id")
    @OneToOne
    private CreditCard card;

}
