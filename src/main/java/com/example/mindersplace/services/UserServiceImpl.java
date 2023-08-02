package com.example.mindersplace.services;

import com.example.mindersplace.data.models.User;
import com.example.mindersplace.data.repositories.UserRepository;
import com.example.mindersplace.dtos.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService{

    private  final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return  userRepository.save(user);
    }

    @Override
    public User findByEmailAddress(String emailAddress) {
        return userRepository.findUserByEmailAddressIgnoreCase(emailAddress).orElse(null);
    }

}
