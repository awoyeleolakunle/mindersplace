package com.example.mindersplace.services;

import com.example.mindersplace.data.models.Minder;
import com.example.mindersplace.data.repositories.MinderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MinderServiceImpl implements MinderService{
    private final MinderRepository minderRepository;

    @Override
    public Minder registerMinder(Minder minder) {
        return minderRepository.save(minder);
    }
}
