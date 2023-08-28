package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Minder;
import com.example.mindersplace.data.repositories.MinderRepository;
import com.example.mindersplace.dtos.request.ClockRecordRequest;
import com.example.mindersplace.utils.ApiResponse;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MinderServiceImpl implements MinderService{
    private final MinderRepository minderRepository;

    @Override
    public Minder saveMinder(Minder minder) {
        return minderRepository.save(minder);
    }

    @Override
    public ApiResponse clockInClockOut(ClockRecordRequest ClockRecordRequest, String emailAddress) {

        return null;
    }

    @Override
    public Minder findByEmailAddress(String minderEmailAddress) {
        System.out.println("I'm here now");
        Optional<Minder> foundMinder = minderRepository.findByUser_EmailAddress(minderEmailAddress);
        if(foundMinder.isPresent()){
            System.out.println("I'm the found minder " + foundMinder.get());
            return foundMinder.get();
        }
        return null;
    }
}
