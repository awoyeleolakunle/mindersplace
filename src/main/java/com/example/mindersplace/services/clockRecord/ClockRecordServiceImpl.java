package com.example.mindersplace.services.clockRecord;

import com.example.mindersplace.data.models.ClockRecord;
import com.example.mindersplace.data.repositories.ClockRecordRepository;
import com.example.mindersplace.dtos.request.ClockRecordRequest;
import com.example.mindersplace.services.MinderService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class ClockRecordServiceImpl implements ClockRecordService {
    private final ClockRecordRepository clockRecordRepository;
    private final ModelMapper modelMapper;
    private final MinderService minderService;

    @Override
    public ApiResponse saveClockRecord(String MindersEmailAddress) {
        ClockRecord clockRecord = new ClockRecord();
        clockRecord.setClcokIn(LocalDateTime.now());
        ClockRecord foundClockRecord = clockRecordRepository.save(clockRecord);
        var foundMinder = minderService.findByEmailAddress(MindersEmailAddress);
        List<ClockRecord> listOfRecords = foundMinder.getClockRecord();
        listOfRecords.add(foundClockRecord);
        foundMinder.setClockRecord(new ArrayList<>(listOfRecords));
        minderService.registerMinder(foundMinder);
        return GenerateApiResponse.sendData(foundClockRecord.getId());
    }

    @Override
    public ApiResponse clockIn(String MindersEmailAddress) {
        return saveClockRecord(MindersEmailAddress);
    }

    @Override
    public ApiResponse clockOut(Object id) {
        Optional<ClockRecord> foundClockRecord = clockRecordRepository.findById((Long) id);
       if (foundClockRecord.isPresent()){
           ClockRecord record = foundClockRecord.get();
           record.setClockOUt(LocalDateTime.now());
           clockRecordRepository.save(record);
           return GenerateApiResponse.okResponse(GenerateApiResponse.CLOCK_OUT_SUCCESSFUL);
       }
        return GenerateApiResponse.notOkResponse(GenerateApiResponse.RECORD_NOT_FOUND);
    }


}
