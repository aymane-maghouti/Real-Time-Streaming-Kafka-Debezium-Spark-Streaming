package com.example.realTimeApp.repository;

import com.example.realTimeApp.models.MaxScreenSizePerSimType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaxScreenSizePerSimTypeRepository extends JpaRepository<MaxScreenSizePerSimType, String> {
}
