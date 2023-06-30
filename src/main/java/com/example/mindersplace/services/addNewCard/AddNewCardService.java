package com.example.mindersplace.services.addNewCard;

import com.example.mindersplace.data.models.Card;
import com.example.mindersplace.dtos.request.CardRequest;
import com.example.mindersplace.utils.ApiResponse;



public interface AddNewCardService {
    ApiResponse addNewCard(CardRequest cardRequest, String emailAddress);

//    List<Card> findAllCard(String emailAddress);
}
