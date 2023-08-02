package com.example.mindersplace.controller;


import com.example.mindersplace.dtos.request.CardRequest;
import com.example.mindersplace.services.addNewCard.AddNewCardService;
import com.example.mindersplace.utils.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*")
public class AddNewCardController {
    private final AddNewCardService addNewCardService;

    @PostMapping("addNewCard")
    ResponseEntity<ApiResponse> addNewCard(@RequestBody CardRequest cardRequest, @RequestParam String parentEmailAddress){
        var response = addNewCardService.addNewCard(cardRequest, parentEmailAddress);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
