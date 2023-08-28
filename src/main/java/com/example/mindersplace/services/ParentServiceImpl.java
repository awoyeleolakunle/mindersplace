package com.example.mindersplace.services;
import com.example.mindersplace.data.models.Child;
import com.example.mindersplace.data.models.Parent;
import com.example.mindersplace.data.repositories.ParentRepository;
import com.example.mindersplace.dtos.request.ChildRegistrationRequest;

import com.example.mindersplace.services.childService.ChildService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParentServiceImpl implements ParentService{
    private final ParentRepository parentRepository;
    private final ChildService childService;
    @Override
    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public ApiResponse addAChild(String parentEmailAddress, ChildRegistrationRequest childRegistrationRequest) {
         Optional<Parent> parent = parentRepository.findByUser_EmailAddress(parentEmailAddress);

        if (parent.isPresent()) {
            log.info("i'm the parent {}", parent.get());

            //childRegistrationRequest.setParent(parent.get());
            Child child = childService.save(childRegistrationRequest);
                var foundChild = parent.get().getChild();
                foundChild.add(child);
                parent.get().setChild(new ArrayList<>(foundChild));
             parentRepository.save(parent.get());


            //Child child = childService.save(childRegistrationRequest);

            log.info("i'm the parent saved in the database {}", parent.get());
            log.info(" I'm the parent's id {} ", parent.get().getId());
            log.info("i'm the child {} " , parent.get().getChild());
           //var list = foundParent.getChild();
           //list.add(childService.save(childRegistrationRequest));

           //foundParent.setChild(list);
            log.info("i'm the child after saving {}", (parent.get().getChild()));
        }
            return GenerateApiResponse.createdResponse(GenerateApiResponse.CHILD_SUCCESSFULLY_REGISTERED);
    }

    @Override
    public Parent findByUserEmailAddress(String emailAddress) {

        System.out.println("yes yes yes ");

        Optional<Parent> parent  = parentRepository.findByUser_EmailAddress(emailAddress);
        if(parent.isPresent()){

          Parent foundParent = parent.get();
            System.out.println("yes yes yes " + foundParent);
          return foundParent;
        }
        return null;
    }

    @Override
    public List<Child> findAllChild(String parentEmailAddress) {
    Optional<Parent> foundParent = parentRepository.findByUser_EmailAddress(parentEmailAddress);
    if(foundParent.isPresent()){
        Parent parent = foundParent.get();
        return parent.getChild();
    }
    return null;
    }
}
