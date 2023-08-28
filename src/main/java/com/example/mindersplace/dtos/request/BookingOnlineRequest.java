package com.example.mindersplace.dtos.request;

import com.example.mindersplace.data.models.Child;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookingOnlineRequest {
    private LocalDate date;
    private String startTime;
    private String finishTime;
    private List<Long> child;
}
