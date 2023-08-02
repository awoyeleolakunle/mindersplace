package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.ClockRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClockRecordRepository extends JpaRepository<ClockRecord, Long> {

}
