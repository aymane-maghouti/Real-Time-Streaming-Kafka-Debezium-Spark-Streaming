package com.example.realTimeApp.service.impl;

import com.example.realTimeApp.models.MaxRamPerBrand;
import com.example.realTimeApp.repository.MaxRamPerBrandRepository;
import com.example.realTimeApp.service.MaxRamPerBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaxRamPerBrandServiceImpl implements MaxRamPerBrandService {

    @Autowired
    private MaxRamPerBrandRepository maxRamPerBrandRepository;

    @Override
    public List<MaxRamPerBrand> getAllMaxRamPerBrand() {
        return maxRamPerBrandRepository.findAll();
    }
}
