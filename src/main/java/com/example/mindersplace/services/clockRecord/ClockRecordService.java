package com.example.mindersplace.services.clockRecord;

import com.example.mindersplace.data.models.ClockRecord;
import com.example.mindersplace.dtos.request.ClockInRequest;
import com.example.mindersplace.dtos.request.ClockOutRequest;
import com.example.mindersplace.dtos.request.ClockRecordRequest;
import com.example.mindersplace.dtos.response.WorkHistoryResponse;
import com.example.mindersplace.utils.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface ClockRecordService {
    ApiResponse saveClockRecord( String MindersEmailAddress);

    ApiResponse clockIn(String MindersEmailAddress, ClockInRequest clockInRequest);

    ApiResponse clockOut(Object id, ClockOutRequest clockOutRequest);

}
