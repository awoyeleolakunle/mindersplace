package com.example.mindersplace.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class   Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    @OneToMany
    private List <CardImagesUrl> cardImagesUrls = new ArrayList<>();
//    @OneToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "user_id")
   // @Column(name = )
//    private User user;
}

