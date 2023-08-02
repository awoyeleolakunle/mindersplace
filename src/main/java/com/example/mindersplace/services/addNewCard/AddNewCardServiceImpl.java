package com.example.mindersplace.services.addNewCard;


import com.example.mindersplace.data.models.CreditCard;
import com.example.mindersplace.data.models.User;
import com.example.mindersplace.data.repositories.CreditCardRepository;
import com.example.mindersplace.data.repositories.UserRepository;
import com.example.mindersplace.dtos.request.CardRequest;
import com.example.mindersplace.services.UserService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Slf4j

@Service
@AllArgsConstructor
public class AddNewCardServiceImpl implements AddNewCardService {
    private final ModelMapper modelMapper;
    private final CreditCardRepository creditCardRepository;
    private final UserService userService;


    @Override
    public ApiResponse addNewCard(CardRequest cardRequest, String parentEmailAddress) {
        User user = userService.findByEmailAddress(parentEmailAddress);
        var foundCreditCard = creditCardRepository.findByCardNumber(cardRequest.getCardNumber());
        foundCreditCard.ifPresent(System.out::println);
        if (user != null && foundCreditCard.isEmpty()) {
            CreditCard card = modelMapper.map(cardRequest, CreditCard.class);
             var savedCard = creditCardRepository.save(card);
            user.setCard(savedCard);
            userService.saveUser(user);

          //  cardRepository.save(card);
            return GenerateApiResponse.createdResponse(GenerateApiResponse.CARD_SUCCESSFULLY_SAVED);
        }

            return GenerateApiResponse.notOkResponse(GenerateApiResponse.INVALID_CREDENTIALS);
    }
//
//    @Override
//    public List<Card> findAllCard(String emailAddress) {
//        return cardRepository.findAllCardsByUserEmailAddress(emailAddress);
//    }
}
