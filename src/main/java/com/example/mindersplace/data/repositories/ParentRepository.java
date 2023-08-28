package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<Parent, Long> {

    Optional<Parent> findByUser_EmailAddress(String emailAddress);

}
