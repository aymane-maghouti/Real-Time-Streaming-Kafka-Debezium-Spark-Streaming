package com.example.realTimeApp.repository;

import com.example.realTimeApp.models.MaxPricePerBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaxPricePerBrandRepository extends JpaRepository<MaxPricePerBrand, String> {
}
