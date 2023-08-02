package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChildRepository extends JpaRepository<Child, Long> {
    Optional<Child> findChildByFirstNameAndLastName(String firstName, String lastName);
}
