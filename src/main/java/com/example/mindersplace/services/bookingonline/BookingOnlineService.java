package com.example.mindersplace.services.bookingonline;

import com.example.mindersplace.data.models.BookingRecord;
import com.example.mindersplace.dtos.request.BookingOnlineRequest;
import com.example.mindersplace.utils.ApiResponse;

import java.util.List;

public interface BookingOnlineService {
   ApiResponse bookOnline(BookingOnlineRequest bookingOnlineRequest, String emailAddress);

   List<BookingRecord> fetchParentBookingHistory(String parentEmailAddress);

   BookingRecord fetchBookingRecord(Long bookingId);

}
