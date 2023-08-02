package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Minder;
import com.example.mindersplace.data.repositories.MinderRepository;
import com.example.mindersplace.dtos.request.ClockRecordRequest;
import com.example.mindersplace.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MinderServiceImpl implements MinderService{
    private final MinderRepository minderRepository;

    @Override
    public Minder registerMinder(Minder minder) {
        return minderRepository.save(minder);
    }

    @Override
    public ApiResponse clockInClockOut(ClockRecordRequest ClockRecordRequest, String emailAddress) {

        return null;
    }

    @Override
    public Minder findByEmailAddress(String emailAddress) {
        Optional<Minder> foundMinder = minderRepository.findByUserEmailAddress(emailAddress);
        return foundMinder.orElse(null);
    }
}
