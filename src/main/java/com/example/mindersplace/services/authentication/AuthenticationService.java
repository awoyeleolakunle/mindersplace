package com.example.mindersplace.services.authentication;

import com.example.mindersplace.data.models.*;

import com.example.mindersplace.dtos.request.EmailNotificationRequest;
import com.example.mindersplace.dtos.request.LoginRequest;
import com.example.mindersplace.dtos.request.RegistrationRequest;
import com.example.mindersplace.exceptions.UserException;
import com.example.mindersplace.exceptions.UserManagementException;
import com.example.mindersplace.mail.MailService;
import com.example.mindersplace.security.JwtService;
import com.example.mindersplace.services.*;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final ParentService parentService;
    private final MinderService minderService;
    private final UserService userService;


    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    private final TokenService tokenService;

    private final VerificationTokenService verificationTokenService;

    private final TemplateEngine templateEngine;
    @Autowired
    private final MailService mailService;


    public ApiResponse Register( RegistrationRequest registrationRequest) {
        boolean userIsRegistered = userService.findByEmailAddress(registrationRequest.getEmailAddress()) != null;
        if (userIsRegistered) throw new UserException("User already exists");
        User savedUser = buildSavedUser(registrationRequest);
        if (registrationRequest.getUserCategory().toUpperCase().equals("PARENT")) {
            Parent parent = Parent.builder()
                    .userName(registrationRequest.getUserName())
                    .user(savedUser)
                    .build();
                parent.setUser(savedUser);
            parentService.saveParent(parent);

        } else {
            if (registrationRequest.getUserCategory().toUpperCase().equals("MINDER")) {
                Minder minder = Minder.builder()
                        .country(registrationRequest.getCountry())
                        .applicationCode(registrationRequest.getApplicationCode())
                        .jobTitle(registrationRequest.getJobTitle())
                        .unitCity(registrationRequest.getUnitCity())
                        .user(savedUser)
                        .build();
                minderService.registerMinder(minder);
            }
        }

//        String token = generateVerificationToken(4);
//        log.info(token);
//        VerificationToken verificationToken = new VerificationToken(
//                token,
//                LocalDateTime.now().plusMinutes(15),
//                LocalDateTime.now(),
//                savedUser
//        );
//        log.info("here i am....1 {}", verificationToken.getVerificationToken());
//
//        verificationTokenService.save(verificationToken);
//        log.info(verificationToken.getVerificationToken());
//        EmailNotificationRequest emailNotificationRequest = buildNotificationRequest(savedUser.getEmailAddress(), savedUser.getFirstName(), verificationToken.getVerificationToken());
//        String response = mailService.sendMail(emailNotificationRequest);
//        if(response==null){
//            return GenerateApiResponse.notOkResponse(GenerateApiResponse.TRY_AGAIN);
//        }
            UserDetails userDetails = userDetailsService.loadUserByUsername(savedUser.getEmailAddress());
            String jwt = jwtService.generateToken(userDetails);
            return GenerateApiResponse.createdResponse(jwt);
    }

    private EmailNotificationRequest buildNotificationRequest(String email, String firstName, String token) {
        EmailNotificationRequest request = new EmailNotificationRequest();
        request.setRecipientEmailAddress(email);
        log.info(email);
        log.info(firstName, token);

        Context context = new Context();
        Map<String, Object> map = new HashMap<>();
        map.put("firstName", firstName);
        map.put("token", token);
        context.setVariables (Map.of("firstName", firstName, "token", token));
        log.info(context.toString());
        String content = templateEngine.process ("Activate", context);
        request.setHtmlContent (content);
        log.info("I'm the request's content {}",request.getHtmlContent() );
        return request;
    }

    private String generateVerificationToken(int lenght) {
        byte [] bytes = new byte[lenght];
        new SecureRandom().nextBytes(bytes);
        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(bytes);
    }

    private User buildSavedUser(RegistrationRequest registrationRequest) {
        Set<Roles> userRoles = new HashSet<>();
        userRoles.add(Roles.PARENT);
        userRoles.add(Roles.USER);
        User user = User.builder()
                .emailAddress(registrationRequest.getEmailAddress())
                .lastName(registrationRequest.getLastName())
                .firstName(registrationRequest.getFirstName())
                .userName(registrationRequest.getUserName())
                .city(registrationRequest.getCity())
                .password(passwordEncoder.encode(registrationRequest.getPassword()))
                .userCategory(UserCategory.valueOf(registrationRequest.getUserCategory().toUpperCase()))
                .postCode(registrationRequest.getPostCode())
                .address(registrationRequest.getAddress())
                .roles(userRoles)
                .build();
        return userService.saveUser(user);
    }

    public ApiResponse login(LoginRequest loginRequest){
        authenticateUser(loginRequest);
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmailAddress());
        if(userDetails== null) throw new UserManagementException("Unknown User");
        String jwt = jwtService.generateToken(userDetails);
       // revokeAllUserToken(loginRequest.getEmailAddress());
        saveToken(jwt, loginRequest.getEmailAddress());
        return GenerateApiResponse.okResponse("Bearer "+jwt);
    }

    private void saveToken(String jwt, String emailAddress) {
        Token token = Token.builder()
                .jwt(jwt)
                .isExpired(false)
                .isRevoked(false)
                .userEmailAddress(emailAddress)
                .build();
        tokenService.saveToken(token);
        //tokenRepository.save(token);
    }

    private void revokeAllUserToken(String emailAddress) {
        var allUsersToken = tokenService.findTokenByUserEmailAddress(emailAddress);
        if(allUsersToken.isEmpty()) return;
        allUsersToken
                .ifPresent(token -> {
                    token.setRevoked(true);
                    token.setExpired(true);
                    tokenService.saveToken(token);
                });
    }

    private void authenticateUser(LoginRequest loginRequest) {
        authenticationManager.authenticate( new UsernamePasswordAuthenticationToken
                (loginRequest.getEmailAddress(), loginRequest.getPassword()));
    }

    @PostConstruct
    public void createUser(){
        Set<Roles> userRoles = new HashSet<>();
        userRoles.add(Roles.ADMIN);
        User user = User.builder()
                .emailAddress("prof@gmail.com")
                .password(passwordEncoder.encode("ab1"))
                .roles(userRoles)
                .build();
        userService.saveUser(user);
    }
}
