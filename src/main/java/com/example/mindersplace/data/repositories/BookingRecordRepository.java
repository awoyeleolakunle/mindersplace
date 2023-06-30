package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRecordRepository  extends JpaRepository<BookingRecord, Long> {
}
