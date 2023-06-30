package com.example.mindersplace.controller;

import com.example.mindersplace.dtos.request.BookingOnlineRequest;
import com.example.mindersplace.services.bookingonline.BookingOnlineService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/")
@CrossOrigin(origins= "*")
public class BookOnlineController {
    private final BookingOnlineService bookingOnlineService;

    @PostMapping("bookOnline/{emailAddress}")
    public ResponseEntity<ApiResponse> bookOnline(@RequestBody  BookingOnlineRequest bookingOnlineRequest, @PathVariable String emailAddress){
        ApiResponse response = bookingOnlineService.bookOnline(bookingOnlineRequest, emailAddress);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
