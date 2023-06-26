package com.example.mindersplace.data.repositories;

import com.example.mindersplace.data.models.HomeChildCareRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeChildCareRepository extends JpaRepository <HomeChildCareRegistration, Long> {

}
