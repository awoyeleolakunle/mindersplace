package com.example.mindersplace.services.addNewCard;

import com.example.mindersplace.dtos.request.CardRequest;
import com.example.mindersplace.utils.ApiResponse;



public interface AddNewCardService {
    ApiResponse addNewCard(CardRequest cardRequest, String parentEmailAddress);

//    List<Card> findAllCard(String emailAddress);
}
