package com.example.mindersplace.services.bookingonline;

import com.example.mindersplace.data.models.BookingRecord;
import com.example.mindersplace.data.models.Child;
import com.example.mindersplace.data.models.Parent;
import com.example.mindersplace.data.repositories.BookingRecordRepository;
import com.example.mindersplace.data.repositories.ChildRepository;
import com.example.mindersplace.dtos.request.BookingOnlineRequest;

import com.example.mindersplace.services.ParentService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class BookingOnlineServiceImpl implements BookingOnlineService{


    private final ParentService parentService;
    private final BookingRecordRepository bookingRecordRepository;



    private final ChildRepository childRepository;

    @Override
    public ApiResponse bookOnline(BookingOnlineRequest bookingOnlineRequest, String emailAddress) {
        System.out.println("i entered bookings");
        System.out.println("I am the online booking childList" + bookingOnlineRequest.getChild());
        Set<Long> uniqueChildIds = new HashSet<>();
        List<Child> newChildList = new ArrayList<>();

        for (Long childId : bookingOnlineRequest.getChild()) {
            if (!uniqueChildIds.contains(childId)) {
                uniqueChildIds.add(childId);
                var foundChild = childRepository.findById(childId);
                foundChild.ifPresent(newChildList::add);
            }
        }
        Parent foundParent = parentService.findByUserEmailAddress(emailAddress);
        if (foundParent != null) {
            BookingRecord bookingRecord = new BookingRecord();
            bookingRecord.setStartTime(bookingOnlineRequest.getStartTime());
            bookingRecord.setFinishTime(bookingOnlineRequest.getFinishTime());
            bookingRecord.setDate(bookingOnlineRequest.getDate());
            bookingRecord.setChild(newChildList);
            BookingRecord savedBookingRecord = bookingRecordRepository.save(bookingRecord);
            List<BookingRecord> newList = foundParent.getBookingRecord();
            newList.add(savedBookingRecord);
            foundParent.setBookingRecord(new ArrayList<>(newList));
            parentService.saveParent(foundParent);
            return GenerateApiResponse.createdResponse(savedBookingRecord);
        } else {
            return GenerateApiResponse.notOkResponse(GenerateApiResponse.USER_NOT_FOUND);
        }
    }







    // BookingRecord bookingRecord = modelMapper.map(bookingOnlineRequest, BookingRecord.class);
//        BookingRecord bookingRecord = new BookingRecord();
//        bookingRecord.setStartTime(bookingOnlineRequest.getStartTime());
//        bookingRecord.setFinishTime(bookingOnlineRequest.getFinishTime());
//        bookingRecord.setDate(bookingOnlineRequest.getDate());
//        bookingRecord.setChild(newChildList);
//        BookingRecord savedBookingRecord = bookingRecordRepository.save(bookingRecord);
//        Parent foundParent = parentService.findByUserEmailAddress(emailAddress);
//        List<BookingRecord> newList =  foundParent.getBookingRecord();
//        newList.add(savedBookingRecord);
//        foundParent.setBookingRecord(new ArrayList<>(newList));
//        parentService.saveParent(foundParent);
//        return GenerateApiResponse.createdResponse(savedBookingRecord);


    @Override
    public List<BookingRecord> fetchParentBookingHistory(String parentEmailAddress) {
        Parent parent = parentService.findByUserEmailAddress(parentEmailAddress);
        System.out.println("i got here");
        return parent.getBookingRecord();
    }

    @Override
    public BookingRecord fetchBookingRecord(Long bookingId) {
        Optional<BookingRecord> foundBookingRecord = bookingRecordRepository.findById(bookingId);
        return foundBookingRecord.orElse(null);
    }
}
