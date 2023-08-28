package com.example.mindersplace.services.workHistory;

import com.example.mindersplace.data.models.Minder;
import com.example.mindersplace.data.models.User;
import com.example.mindersplace.dtos.request.ClockInRequest;
import com.example.mindersplace.dtos.request.ClockOutRequest;
import com.example.mindersplace.services.MinderService;
import com.example.mindersplace.services.UserService;
import com.example.mindersplace.services.clockRecord.ClockRecordService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@Slf4j
class WorkHistoryServicesImplTest {
    @Autowired
    private MinderService minderService;

    @Autowired
    private WorkHistoryServices workHistoryServices;

    @Autowired
    private UserService userService;

    @Autowired
    private ClockRecordService clockRecordService;
     @Test
    void testThatAMinderCanViewWorkHistory(){
         User user = new User();
         user.setEmailAddress("emailAddress");
         user.setPassword("password");
         userService.saveUser(user);

         Minder minder = new Minder();
         minder.setUser(user);
         minderService.saveMinder(minder);

         ClockInRequest clockInRequest = new ClockInRequest();
         clockInRequest.setClockInTime("7:00 AM");

         ClockOutRequest clockOutRequest = new ClockOutRequest();
         clockOutRequest.setClockOutTime("3:00 PM");
         var savedClockRecord = clockRecordService.clockIn(minder.getUser().getEmailAddress(), clockInRequest);
         clockRecordService.clockOut(savedClockRecord.getData(), clockOutRequest );

         log.info("I'm the first clockRecord {} ", savedClockRecord);


         ClockInRequest clockInRequest1 = new ClockInRequest();
         clockInRequest1.setClockInTime("9:00 AM");

         ClockOutRequest clockOutRequest1 = new ClockOutRequest();
         clockOutRequest1.setClockOutTime("4:00 PM");

       var secondSavedClockRecord = clockRecordService.clockIn("emailAddress", clockInRequest1 );
       clockRecordService.clockOut(secondSavedClockRecord.getData(), clockOutRequest1);

       log.info("I'm the second clockRecord {} ", secondSavedClockRecord);

     }


}