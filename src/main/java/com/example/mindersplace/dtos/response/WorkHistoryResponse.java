package com.example.mindersplace.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkHistoryResponse {
    private LocalDateTime clcokIn;
    private LocalDateTime clockOut;
}
