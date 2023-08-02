package com.example.mindersplace.services.addNewCard;

import com.example.mindersplace.data.models.User;
import com.example.mindersplace.data.models.UserCategory;
import com.example.mindersplace.dtos.request.CardRequest;
import com.example.mindersplace.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest

class AddNewCardServiceImplTest {

    @Autowired
    private AddNewCardService addNewCardService;
    @Autowired
    private UserService userService;

    @Test
    void testThatAUserCanSaveACard(){
        CardRequest cardRequest = new CardRequest();
        cardRequest.setCardHolderName("CardHolderName");
        cardRequest.setCardNumber("545677");
     //   cardRequest.setExpiryDate("01-01-2023");
        cardRequest.setCvv("737");
        User user = new User();
        user.setEmailAddress("email");
        user.setUserCategory(UserCategory.PARENT);

         var savedUser = userService.saveUser(user);
        addNewCardService.addNewCard(cardRequest, savedUser.getEmailAddress());

        assertThat(userService.findByEmailAddress(user.getEmailAddress()).getCard()).isNotNull();
    }
}