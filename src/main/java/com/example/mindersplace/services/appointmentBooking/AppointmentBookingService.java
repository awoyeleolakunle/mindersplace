package com.example.mindersplace.services;

import com.example.mindersplace.dtos.request.AppointmentBookingRequest;
import com.example.mindersplace.utils.ApiResponse;

public interface AppointmentBookingService {
    ApiResponse bookAppointment(AppointmentBookingRequest  appointmentBookingRequest);
}
