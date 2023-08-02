package com.example.mindersplace.data.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity (name = "credit_card")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    private String expiryMonth;
    private String expiryYear;
    @OneToMany(fetch = FetchType.EAGER)
    private List<CardImagesUrl> cardImagesUrls;

//    @OneToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "user_id")
    // @Column(name = )
//    private User user;

}
