package com.example.mindersplace.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardRequest {
    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    private String cardImageUrl;
    private String expiryDate;
}
