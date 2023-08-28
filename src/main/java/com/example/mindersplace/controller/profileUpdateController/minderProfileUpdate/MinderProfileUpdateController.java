package com.example.mindersplace.controller.profileUpdateController.minderProfileUpdate;


import com.example.mindersplace.dtos.request.MinderProfileUpdateRequest;
import com.example.mindersplace.services.profileUpdate.minderProfileUpdate.MinderProfileService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/")
@AllArgsConstructor
public class MinderProfileUpdateController {

    private final MinderProfileService minderProfileService;

    @PostMapping("minderProfileUpdate")
    public ResponseEntity<ApiResponse> updateMinderProfile(@RequestParam String minderEmailAddress, @RequestBody MinderProfileUpdateRequest minderProfileUpdateRequest){
        return new ResponseEntity<>(minderProfileService.updateMinderProfileDetails(minderEmailAddress, minderProfileUpdateRequest), HttpStatus.OK);
    }
}
