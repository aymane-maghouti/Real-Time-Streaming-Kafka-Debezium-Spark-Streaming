package com.example.realTimeApp.service.impl;

import com.example.realTimeApp.models.MaxBatteryPerBrand;
import com.example.realTimeApp.repository.MaxBatteryPerBrandRepository;
import com.example.realTimeApp.service.MaxBatteryPerBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaxBatteryPerBrandServiceImpl implements MaxBatteryPerBrandService {


    @Autowired
    private MaxBatteryPerBrandRepository maxBatteryPerBrandRepository;

    @Override
    public List<MaxBatteryPerBrand> getAllMaxBatteryPerBrand() {
        return maxBatteryPerBrandRepository.findAll();
    }
}
