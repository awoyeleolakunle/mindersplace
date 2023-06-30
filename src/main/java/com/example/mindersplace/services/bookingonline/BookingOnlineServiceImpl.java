package com.example.mindersplace.services.bookingonline;

import com.example.mindersplace.data.models.BookingRecord;
import com.example.mindersplace.data.models.Parent;
import com.example.mindersplace.data.repositories.BookingRecordRepository;
import com.example.mindersplace.dtos.request.BookingOnlineRequest;
import com.example.mindersplace.services.ParentService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BookingOnlineServiceImpl implements BookingOnlineService{

    private final ModelMapper modelMapper;
    private final ParentService parentService;
    private final BookingRecordRepository bookingRecordRepository;



    @Override
    public ApiResponse bookOnline(BookingOnlineRequest bookingOnlineRequest, String emailAddress) {
        BookingRecord bookingRecord = modelMapper.map(bookingOnlineRequest, BookingRecord.class);
        BookingRecord savedBookingRecord = bookingRecordRepository.save(bookingRecord);
        Parent foundParent = parentService.findByUserEmailAddress(emailAddress);
        List<BookingRecord> newList =  foundParent.getBookingRecord();
        newList.add(savedBookingRecord);
        foundParent.setBookingRecord(new ArrayList<>(newList));
        parentService.saveParent(foundParent);
        return GenerateApiResponse.createdResponse(savedBookingRecord);
    }
}
