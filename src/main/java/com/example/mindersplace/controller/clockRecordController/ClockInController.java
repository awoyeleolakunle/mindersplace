package com.example.mindersplace.controller.clockRecordController;


import com.example.mindersplace.dtos.request.ClockInRequest;
import com.example.mindersplace.services.clockRecord.ClockRecordService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping  ("api/v1/")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ClockInController {
    private final ClockRecordService clockRecordService;

    @PostMapping("clockIn")
    public ResponseEntity<ApiResponse> clockIn(@RequestParam String minderEmailAddress, @RequestBody ClockInRequest clockInRequest){
        return new ResponseEntity<>(clockRecordService.clockIn(minderEmailAddress, clockInRequest), HttpStatus.OK);
    }
}
