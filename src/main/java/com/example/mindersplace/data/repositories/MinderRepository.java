package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.Minder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MinderRepository extends JpaRepository<Minder, Long> {
}
