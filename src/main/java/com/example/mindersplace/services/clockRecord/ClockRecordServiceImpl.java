package com.example.mindersplace.services.clockRecord;

import com.example.mindersplace.data.models.ClockRecord;
import com.example.mindersplace.data.repositories.ClockRecordRepository;
import com.example.mindersplace.dtos.request.ClockInRequest;
import com.example.mindersplace.dtos.request.ClockOutRequest;
import com.example.mindersplace.services.MinderService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@AllArgsConstructor
public class ClockRecordServiceImpl implements ClockRecordService {
    private final ClockRecordRepository clockRecordRepository;

    private final MinderService minderService;

    @Override
    public ApiResponse saveClockRecord(String minderEmailAddress) {
        ClockRecord clockRecord = new ClockRecord();
        clockRecord.setClcokIn(LocalDateTime.now());
        ClockRecord foundClockRecord = clockRecordRepository.save(clockRecord);
        var foundMinder = minderService.findByEmailAddress(minderEmailAddress);
        List<ClockRecord> listOfRecords = foundMinder.getClockRecord();
        listOfRecords.add(foundClockRecord);
        foundMinder.setClockRecord(new ArrayList<>(listOfRecords));
        minderService.saveMinder(foundMinder);
        return GenerateApiResponse.sendData(foundClockRecord.getId());
    }

    @Override
    public ApiResponse clockIn(String minderEmailAddress, ClockInRequest clockInRequest) {

        var foundMinder = minderService.findByEmailAddress(minderEmailAddress);

        if (foundMinder!=null) {
            System.out.println("Here I am " + foundMinder);
            ClockRecord clockRecord = new ClockRecord();
            LocalDateTime clockInDateAndTime = convertTimeInStringToLocalDateTimeObject(clockInRequest.getClockInTime());
            clockRecord.setTimeIn(clockInRequest.getClockInTime());
            clockRecord.setClcokIn(clockInDateAndTime);
            clockRecord.setDayOfTheWeek(clockInDateAndTime.getDayOfWeek().toString());
            System.out.println(clockInDateAndTime.getDayOfWeek());
            ClockRecord savedClockRecord = clockRecordRepository.save(clockRecord);

            List<ClockRecord> listOfRecords = foundMinder.getClockRecord();
            listOfRecords.add(savedClockRecord);
            foundMinder.setClockRecord(new ArrayList<>(listOfRecords));
            minderService.saveMinder(foundMinder);

            return ApiResponse.builder()
                    .data(clockRecord.getId())
                    .isSuccessful(true)
                    .httpStatus(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build();
        }
        return ApiResponse.builder()
                .isSuccessful(false)
                .build();
    }

        @Override
        public ApiResponse clockOut (Object id, ClockOutRequest clockOutRequest){
            Optional<ClockRecord> foundClockRecord = clockRecordRepository.findById((Long) id);
            if (foundClockRecord.isPresent()) {
                ClockRecord clockRecord = foundClockRecord.get();
                LocalDateTime clockOutDateAndTime = convertTimeInStringToLocalDateTimeObject(clockOutRequest.getClockOutTime());
                clockRecord.setTimeOut(clockOutRequest.getClockOutTime());
                clockRecord.setClockOUt(clockOutDateAndTime);
                clockRecordRepository.save(clockRecord);
                return GenerateApiResponse.okResponse(GenerateApiResponse.CLOCK_OUT_SUCCESSFUL);
            }

            return GenerateApiResponse.notOkResponse(GenerateApiResponse.RECORD_NOT_FOUND);
        }


    private LocalDateTime convertTimeInStringToLocalDateTimeObject(String time){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        LocalTime localTime = LocalTime.parse(time.toUpperCase(), formatter);
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime.with(localTime);
    }

}
