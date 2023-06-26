package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.AppointmentBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentBookingRepository extends JpaRepository<AppointmentBooking, Long> {

}
