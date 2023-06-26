package com.example.mindersplace.security;

import com.example.mindersplace.data.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.example.mindersplace.services.UserService;

@Component
@RequiredArgsConstructor

public class SecuredUserDetailsService implements UserDetailsService {

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user =   userService.findByEmailAddress(username);
        return new SecuredUser(user);
    }
}
