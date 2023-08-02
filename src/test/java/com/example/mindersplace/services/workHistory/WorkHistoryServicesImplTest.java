package com.example.mindersplace.services.workHistory;

import com.example.mindersplace.data.models.ClockRecord;
import com.example.mindersplace.data.models.Minder;
import com.example.mindersplace.data.models.User;
import com.example.mindersplace.dtos.request.ClockRecordRequest;
import com.example.mindersplace.services.MinderService;
import com.example.mindersplace.services.UserService;
import com.example.mindersplace.services.clockRecord.ClockRecordService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;


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
         minderService.registerMinder(minder);
         var savedClockRecord = clockRecordService.clockIn(minder.getUser().getEmailAddress());
         clockRecordService.clockOut(savedClockRecord.getData());

         log.info("I'm the first clockRecord {} ", savedClockRecord);

       var secondSavedClockRecord = clockRecordService.clockIn("emailAddress");
       clockRecordService.clockOut(savedClockRecord.getData());

       log.info("I'm the second clockRecord {} ", secondSavedClockRecord);

     }
}