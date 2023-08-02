package com.example.mindersplace.services.workHistory;

import com.example.mindersplace.data.models.ClockRecord;
import com.example.mindersplace.data.models.Minder;
import com.example.mindersplace.services.MinderService;
import com.example.mindersplace.services.clockRecord.ClockRecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkHistoryServicesImpl implements WorkHistoryServices{
    private final MinderService minderService;

    @Override
    public List<ClockRecord> viewWorkHistory(String minderEmailAddress) {
        Minder foundMinder = minderService.findByEmailAddress(minderEmailAddress);
        List<ClockRecord> listOfClockRecord = foundMinder.getClockRecord();
        return listOfClockRecord;
    }

    }

