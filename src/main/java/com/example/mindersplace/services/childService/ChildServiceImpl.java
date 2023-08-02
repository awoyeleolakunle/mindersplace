package com.example.mindersplace.services.childService;


import com.example.mindersplace.data.models.Child;
import com.example.mindersplace.data.repositories.ChildRepository;
import com.example.mindersplace.dtos.request.ChildRegistrationRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChildServiceImpl implements ChildService {

    private final ChildRepository childRepository;
    private final ModelMapper modelMapper;

    @Override
    public Child save(ChildRegistrationRequest childRegistrationRequest) {
        Child child = modelMapper.map(childRegistrationRequest, Child.class);
        return childRepository.save(child);
    }

    @Override
    public Child merge(Child detachedChild) {
        return childRepository.save(detachedChild);
    }

}
