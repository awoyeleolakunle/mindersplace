package com.example.mindersplace.services.bookingonline;

import com.example.mindersplace.dtos.request.BookingOnlineRequest;
import com.example.mindersplace.utils.ApiResponse;

public interface BookingOnlineService {
   ApiResponse bookOnline(BookingOnlineRequest bookingOnlineRequest, String emailAddress);

}
