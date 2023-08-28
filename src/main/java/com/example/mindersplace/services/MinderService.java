package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Minder;
import com.example.mindersplace.dtos.request.ClockRecordRequest;
import com.example.mindersplace.utils.ApiResponse;

public interface MinderService {
    Minder saveMinder(Minder minder);

    ApiResponse clockInClockOut(ClockRecordRequest ClockRecordRequest, String emailAddress);

    Minder findByEmailAddress(String minderEmailAddress);
}
