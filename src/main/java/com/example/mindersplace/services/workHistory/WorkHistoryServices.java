package com.example.mindersplace.services.workHistory;

import com.example.mindersplace.data.models.ClockRecord;

import java.util.List;

public interface WorkHistoryServices {
     List<ClockRecord> viewWorkHistory(String minderEmailAddress);
}