package com.example.mindersplace.controller;


import com.example.mindersplace.data.models.Child;
import com.example.mindersplace.services.ParentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/")
public class findAllChildController {

    private final ParentService parentService;
    @GetMapping("findAllChild")
    public List<Child> findAllChild(@RequestParam String parentEmailAddress){
        return parentService.findAllChild(parentEmailAddress);
    }

}
