package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
    Optional<CreditCard> findByCardNumber(String creditCardNumber);

}
