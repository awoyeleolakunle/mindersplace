package com.example.mindersplace.services.clockRecord;

import com.example.mindersplace.data.models.Minder;
import com.example.mindersplace.data.models.User;
import com.example.mindersplace.data.models.UserCategory;
import com.example.mindersplace.data.repositories.ClockRecordRepository;
import com.example.mindersplace.dtos.request.ClockRecordRequest;
import com.example.mindersplace.services.MinderService;
import com.example.mindersplace.services.UserService;
import com.example.mindersplace.utils.GenerateApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClockRecordServiceImplTest {
    @Autowired
    private ClockRecordService clockRecordService;
    @Autowired
    private ClockRecordRepository clockRecordRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MinderService minderService;
    @Test
    void testThatAMinderCanClockIn() {
        User user = new User();
        user.setUserCategory(UserCategory.MINDER);
        user.setEmailAddress("emailAddress");
        user.setPassword("password");
        var savedUser = userService.saveUser(user);

        Minder minder = new Minder();
        minder.setUser(savedUser);
        minderService.saveMinder(minder);

        ClockRecordRequest clockRecordRequest = new ClockRecordRequest();
        clockRecordRequest.setClockIn(LocalDateTime.now());
        var clockRecord = clockRecordService.saveClockRecord(minder.getUser().getEmailAddress());
        var savedId = clockRecord.getData();
        assertThat(clockRecord.getData()).isSameAs(savedId);
    }

//    @Test
//    void testThatAMinderCanClockOut(){
//        User user = new User();
//        user.setUserCategory(UserCategory.MINDER);
//        user.setEmailAddress("emailAddress");
//        user.setPassword("password");
//        var savedUser = userService.saveUser(user);
//
//        Minder minder = new Minder();
//        minder.setUser(savedUser);
//        minderService.saveMinder(minder);
//        ClockRecordRequest clockRecordRequest = new ClockRecordRequest();
//        clockRecordRequest.setClockIn(LocalDateTime.now());
//        var clockRecord =  clockRecordService.saveClockRecord(minder.getUser().getEmailAddress());
//        var savedId =  clockRecord.getData();
//
//         var response = clockRecordService.clockOut(savedId);
//         assertThat(response.getData()).isSameAs(GenerateApiResponse.CLOCK_OUT_SUCCESSFUL);
//    }
}