package com.example.mindersplace.controller;


import com.example.mindersplace.data.models.BookingRecord;
import com.example.mindersplace.services.bookingonline.BookingOnlineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("api/v1/")
@CrossOrigin(origins = "*")
@AllArgsConstructor

public class SingleBookingRecordController {

    private final BookingOnlineService bookingOnlineService;

     @PostMapping  ("singleBookingHistory")
    public ResponseEntity<BookingRecord> findSingleBookingRecord(@RequestParam Long bookingId){
         return new ResponseEntity<>(bookingOnlineService.fetchBookingRecord(bookingId), HttpStatus.OK);
     }
}
