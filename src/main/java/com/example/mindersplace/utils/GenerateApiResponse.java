package com.example.mindersplace.utils;

import com.example.mindersplace.data.models.Child;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class GenerateApiResponse {

    public static final String APPOINTMENT_BOOKED_SUCCESSFULLY = "You have successfully booked an appointment with us. " +
            "Kindly check you email. Thank you";
    public static final String  FILL_IN_PROPER_INFORMATION = "Kindly supply sufficient information. Thank you" ;

    public static final String SCHOOL_RUN_REGISTRATION_SUCCESSFUL = "You have successfully registered with us." +
            " We will get back to you shortly";

    public static final String HOME_CHILD_CARE_REGISTRATION_SUCCESSFUL = "Your registration for home child care was successful ";

    public static final String CONTACT_MESSAGE_RECEIVED_SUCCESSFULLY = "Your message has been successfully received";
    public static final String CHILD_SUCCESSFULLY_REGISTERED = "You have successfully registered your child";
    public static final String EMAIL_SUBJECT = "Dear Customer Kindly Follow The Instructions Below";
    public static final String EMAIL_CONTENT = "";
    public static final String RESET_PASSWORD_LINK_FROM_FRONTEND = "Localhost://3000/resetPassword";
    public static final String USER_NOT_FOUND = "Customer With This Email Does Not Exist";
    public static final String PASSWORD_RESET_SUCCESSFULLY = "Dear Customer, You Have Successfully Reset Your Password" ;
    public static final String INVALID_CREDENTIALS = "The credentials You Entered Are Invalid";
    public static final String SESSION_BOOKED_SUCCESSFULLY = "You have successfully book a session for your child";
    public static final String CLOCK_OUT_SUCCESSFUL = "You have successfully clocked out fo today";
    public static final String TRY_AGAIN ="Something went wrong, please try again" ;
    public static final String RECORD_NOT_FOUND = "Record not found, please try again";
    public static final String CARD_SUCCESSFULLY_SAVED ="You have successfully saved a card" ;

    public static ApiResponse createdResponse(Object data) {
        return ApiResponse.builder()
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .httpStatus(HttpStatus.CREATED)
                .data(data)
                .build();
    }

    public static ApiResponse okResponse(Object data) {
        return ApiResponse.builder()
                .statusCode(HttpStatus.OK.value())
                .isSuccessful(true)
                .httpStatus(HttpStatus.OK)
                .data(data)
                .build();
    }
    public static ApiResponse notOkResponse(Object data){
        return ApiResponse.builder()
                .data(data)
                .isSuccessful(false)
                .build();
    }
    public static ApiResponse sendData(Long data ){
        return ApiResponse.builder()
                .data(data)
                .isSuccessful(true)
                .build();
    }

    public static ApiResponse listOfChild(List<Child> childList) {
        return ApiResponse.builder()
                .data(childList)
                .isSuccessful(true)
                .httpStatus(HttpStatus.OK)
                .build();
    }
}

