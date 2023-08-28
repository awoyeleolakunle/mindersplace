package com.example.mindersplace.controller.minderQualificationController;


import com.example.mindersplace.dtos.request.QualificationRequest;
import com.example.mindersplace.services.mindersQualification.MinderQualificationsService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class MinderQualifications {
    private final MinderQualificationsService minderQualificationsService;

    @PostMapping("minderQualifications")
    public ResponseEntity<ApiResponse> saveMinderQualification(@RequestParam String minderEmailAddress, @RequestBody QualificationRequest qualificationRequest){
     return new ResponseEntity<>(minderQualificationsService.saveMinderQualifications(minderEmailAddress, qualificationRequest), HttpStatus.OK);
    }
}
