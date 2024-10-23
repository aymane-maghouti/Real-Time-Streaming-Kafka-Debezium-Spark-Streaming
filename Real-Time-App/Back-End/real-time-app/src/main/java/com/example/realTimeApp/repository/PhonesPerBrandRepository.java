package com.example.realTimeApp.repository;


import com.example.realTimeApp.models.PhonesPerBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesPerBrandRepository  extends JpaRepository<PhonesPerBrand, String> {
}
