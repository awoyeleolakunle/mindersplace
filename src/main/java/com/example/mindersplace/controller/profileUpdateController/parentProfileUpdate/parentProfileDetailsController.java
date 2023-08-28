package com.example.mindersplace.controller.profileUpdateController.parentProfileUpdate;

import com.example.mindersplace.services.profileUpdate.parentProfileUpdate.ParentProfileDetailsService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class parentProfileDetailsController {

    private final ParentProfileDetailsService parentProfileDetailsService;

    @PostMapping("parentProfileDetails")

    public ResponseEntity<ApiResponse> loadParentProfileDetails(@RequestParam String emailAddress){
        return new ResponseEntity<>(parentProfileDetailsService.loadParentProfileDetails(emailAddress), HttpStatus.OK);
    }
}
