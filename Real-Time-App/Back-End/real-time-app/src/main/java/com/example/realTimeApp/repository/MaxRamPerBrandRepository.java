package com.example.realTimeApp.repository;

import com.example.realTimeApp.models.MaxRamPerBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaxRamPerBrandRepository extends JpaRepository<MaxRamPerBrand, String> {
}
