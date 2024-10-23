package com.example.realTimeApp.repository;

import com.example.realTimeApp.models.MaxPricePerSimType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MaxPricePerSimTypeRepository extends JpaRepository<MaxPricePerSimType, String> {
}
