package com.example.mindersplace.services.bookingonline;

import com.example.mindersplace.data.models.*;
import com.example.mindersplace.dtos.request.BookingOnlineRequest;
import com.example.mindersplace.dtos.request.ChildRegistrationRequest;
import com.example.mindersplace.services.ChildService;
import com.example.mindersplace.services.ParentService;
import com.example.mindersplace.services.UserService;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
class BookingOnlineServiceImplTest {

        @Autowired
         private ParentService parentService;

        @Autowired
         private  BookingOnlineService bookingOnlineService;

        @Autowired
         private ChildService childService;
        @Autowired
         private UserService userService;


         @Test
         void testThatAParentCabBookASession(){
             User user = new User();
             user.setEmailAddress("email");
             user.setUserCategory(UserCategory.PARENT);
            var foundUser = userService.saveUser(user);

             ChildRegistrationRequest childRegistrationRequest = new ChildRegistrationRequest();
             childRegistrationRequest.setFirstName("firstName");
             childRegistrationRequest.setMiddleName("middle");
             childRegistrationRequest.setGender(Gender.MALE);
             Child foundChild = childService.save(childRegistrationRequest);

             Parent parent = new Parent();
             parent.setUser(foundUser);
           //  parent.getChild().add(foundChild);
             parentService.saveParent(parent);



             BookingOnlineRequest bookingOnlineRequest = new BookingOnlineRequest();
           //  bookingOnlineRequest.setDate(LocalDate.parse("1/01/2023"));
             bookingOnlineRequest.setStartTime("1pm");
             bookingOnlineRequest.setFinishTime("5pm");
             bookingOnlineRequest.getChild().add(foundChild);
             bookingOnlineService.bookOnline(bookingOnlineRequest, parent.getUser().getEmailAddress());

             log.info("i'm the booking record {}", parentService.findByUserEmailAddress("email").getBookingRecord().size());

             assertThat(parentService.findByUserEmailAddress("email").getBookingRecord()).hasSize(1);
         }
}