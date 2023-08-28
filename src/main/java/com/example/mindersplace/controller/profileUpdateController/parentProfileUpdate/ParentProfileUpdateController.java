package com.example.mindersplace.controller.profileUpdateController.parentProfileUpdate;


import com.example.mindersplace.dtos.request.ProfileUpdateRequest;
import com.example.mindersplace.services.profileUpdate.parentProfileUpdate.ParentProfileService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class ParentProfileUpdateController {

    private final ParentProfileService parentProfileService;

    @PostMapping("parentProfileUpdate")
    public ResponseEntity<ApiResponse> updateParentProfile(@RequestBody ProfileUpdateRequest profileUpdateRequest, @RequestParam String emailAddress){
        return new ResponseEntity<>(parentProfileService.updateParentProfileDetails(profileUpdateRequest, emailAddress), HttpStatus.OK);
    }
}
