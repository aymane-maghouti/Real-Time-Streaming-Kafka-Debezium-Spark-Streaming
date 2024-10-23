package com.example.realTimeApp.repository;


import com.example.realTimeApp.models.PhonesPerSimType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesPerSimTypeRepository extends JpaRepository<PhonesPerSimType, String> {
}
