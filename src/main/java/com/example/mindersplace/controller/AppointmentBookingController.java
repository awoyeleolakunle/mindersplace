package com.example.mindersplace.controller;

import com.example.mindersplace.dtos.request.AppointmentBookingRequest;
import com.example.mindersplace.services.appointmentBooking.AppointmentBookingService;
import com.example.mindersplace.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AppointmentBookingController {

    private final AppointmentBookingService appointmentBookingService;

    @PostMapping("bookAppointment")
    public ResponseEntity<ApiResponse> bookAppointment(@RequestBody @Valid AppointmentBookingRequest request) {
        ApiResponse registrationResponse = appointmentBookingService.bookAppointment(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
    }


}