package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.Minder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MinderRepository extends JpaRepository<Minder, Long> {
    Optional<Minder> findByUser_EmailAddress(String emailAddress);
}

