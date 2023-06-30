package com.example.mindersplace.services.addNewCard;


import com.example.mindersplace.data.models.Card;
import com.example.mindersplace.data.models.User;
import com.example.mindersplace.data.repositories.CardRepository;
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
    private final CardRepository cardRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public ApiResponse addNewCard(CardRequest cardRequest, String emailAddress) {
        //boolean isRegisteredUser = userService.findByEmailAddress(userEmailAddress)!= null;

            User user = userService.findByEmailAddress(emailAddress);
            //var user = userRepository.findUserByEmailAddressIgnoreCase(emailAddress);
            if(user !=null) {
//                var foundUser = user.get();
                Card card = modelMapper.map(cardRequest, Card.class);
                user.setCard(card);
                userService.saveUser(user);
                cardRepository.save(card);
                return GenerateApiResponse.createdResponse(card);
            }



        //}
        return GenerateApiResponse.notOkResponse(GenerateApiResponse.INVALID_CREDENTIALS);
    }
//
//    @Override
//    public List<Card> findAllCard(String emailAddress) {
//        return cardRepository.findAllCardsByUserEmailAddress(emailAddress);
//    }
}
