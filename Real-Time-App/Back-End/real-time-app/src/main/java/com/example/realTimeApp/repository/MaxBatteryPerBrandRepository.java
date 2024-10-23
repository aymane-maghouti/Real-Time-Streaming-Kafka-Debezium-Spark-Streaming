package com.example.realTimeApp.repository;


import com.example.realTimeApp.models.MaxBatteryPerBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaxBatteryPerBrandRepository extends JpaRepository<MaxBatteryPerBrand, String> {
}
