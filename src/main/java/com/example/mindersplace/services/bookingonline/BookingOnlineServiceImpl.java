package com.example.mindersplace.services.bookingonline;

import com.example.mindersplace.data.models.BookingRecord;
import com.example.mindersplace.data.models.Child;
import com.example.mindersplace.data.models.Parent;
import com.example.mindersplace.data.repositories.BookingRecordRepository;
import com.example.mindersplace.data.repositories.ChildRepository;
import com.example.mindersplace.dtos.request.BookingOnlineRequest;
import com.example.mindersplace.services.childService.ChildService;
import com.example.mindersplace.services.ParentService;
import com.example.mindersplace.utils.ApiResponse;
import com.example.mindersplace.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class BookingOnlineServiceImpl implements BookingOnlineService{

    private final ModelMapper modelMapper;
    private final ParentService parentService;
    private final BookingRecordRepository bookingRecordRepository;

    private final ChildService childService;

    private final ChildRepository childRepository;

    @Override
    public ApiResponse bookOnline(BookingOnlineRequest bookingOnlineRequest, String emailAddress) {
        System.out.println("i entered bookings");
        System.out.println("I am the online booking childlist" + bookingOnlineRequest.getChild());
        List<Child> newChildList = new ArrayList<>();
        for ( Child child: bookingOnlineRequest.getChild()) {
            var foundChild = childRepository.findById(child.getId());
            foundChild.ifPresent(newChildList::add);
        }
        BookingRecord bookingRecord = modelMapper.map(bookingOnlineRequest, BookingRecord.class);
        bookingRecord.setChild(newChildList);
     //   List<Child> mergedChildren = new ArrayList<>();
      //  mergedChildren.addAll(bookingOnlineRequest.getChild());
     //   bookingRecord.setChild(mergedChildren);

        BookingRecord savedBookingRecord = bookingRecordRepository.save(bookingRecord);
        Parent foundParent = parentService.findByUserEmailAddress(emailAddress);
        List<BookingRecord> newList =  foundParent.getBookingRecord();
        newList.add(savedBookingRecord);
        foundParent.setBookingRecord(new ArrayList<>(newList));
        parentService.saveParent(foundParent);
        return GenerateApiResponse.createdResponse(savedBookingRecord);
    }

    @Override
    public List<BookingRecord> fetchParentBookingHistory(String parentEmailAddress) {
        Parent parent = parentService.findByUserEmailAddress(parentEmailAddress);
        return parent.getBookingRecord();
    }

    @Override
    public BookingRecord fetchBookingRecord(Long bookingId) {
        Optional<BookingRecord> foundBookingRecord = bookingRecordRepository.findById(bookingId);
        return foundBookingRecord.orElse(null);
    }
}
