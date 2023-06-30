package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

}
