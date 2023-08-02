package com.example.mindersplace.controller;


import com.example.mindersplace.data.models.BookingRecord;
import com.example.mindersplace.services.bookingonline.BookingOnlineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/")
public class ParentBookingHistoryController {

    private final BookingOnlineService bookingOnlineService;

    @PostMapping("parentBookingHistory")
    public ResponseEntity<List<BookingRecord>> findParentBookingHistory(@RequestParam String parentEmailAddress){
        return new ResponseEntity<>(bookingOnlineService.fetchParentBookingHistory(parentEmailAddress), HttpStatus.OK);
    }
}
