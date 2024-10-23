package com.example.realTimeApp.repository;

import com.example.realTimeApp.models.MaxRomPerSimType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaxRomPerSimTypeRepository extends JpaRepository<MaxRomPerSimType, String > {
}
