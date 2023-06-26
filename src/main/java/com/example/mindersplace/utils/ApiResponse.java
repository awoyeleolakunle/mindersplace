package com.example.mindersplace.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ApiResponse {
    private Object data;
    private HttpStatus httpStatus;
    private int statusCode;
    private boolean isSuccessful;
}
