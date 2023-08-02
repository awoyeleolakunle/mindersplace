package com.example.mindersplace.controller;


import com.example.mindersplace.dtos.request.ChildRegistrationRequest;
import com.example.mindersplace.services.ParentService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
 @RequestMapping("api/v1/")
public class AddChildController {
    private final ParentService parentService;

    @PostMapping("addAChild")
    public ResponseEntity<ApiResponse> addAChild(@RequestParam String parentEmail, @RequestBody ChildRegistrationRequest request){
        return ResponseEntity.ok(parentService.addAChild(parentEmail, request));
    }
}
