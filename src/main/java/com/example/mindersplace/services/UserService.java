package com.example.mindersplace.services;

import com.example.mindersplace.data.models.User;

public interface UserService {
    User saveUser(User user);
    User findByEmailAddress(String emailAddress);
}
