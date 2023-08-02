package com.example.mindersplace.services.appointmentBooking;

import com.example.mindersplace.data.models.AppointmentBooking;
import com.example.mindersplace.data.repositories.AppointmentBookingRepository;
import com.example.mindersplace.dtos.request.AppointmentBookingRequest;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppointmentBookingServiceImpl implements AppointmentBookingService{

    private final ModelMapper modelMapper;
    private final AppointmentBookingRepository appointmentBookingRepository;
    @Override
    public ApiResponse bookAppointment(AppointmentBookingRequest appointmentBookingRequest) {
        AppointmentBooking appointmentBooking = modelMapper.map(appointmentBookingRequest, AppointmentBooking.class);
        appointmentBookingRepository.save(appointmentBooking);
            return GenerateApiResponse.createdResponse(GenerateApiResponse.APPOINTMENT_BOOKED_SUCCESSFULLY);
    }
}
