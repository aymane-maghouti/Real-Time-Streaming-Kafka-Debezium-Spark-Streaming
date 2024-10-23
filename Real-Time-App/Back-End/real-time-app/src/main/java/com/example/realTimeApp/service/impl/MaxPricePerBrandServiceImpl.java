package com.example.realTimeApp.service.impl;

import com.example.realTimeApp.models.MaxPricePerBrand;
import com.example.realTimeApp.repository.MaxPricePerBrandRepository;
import com.example.realTimeApp.service.MaxPricePerBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaxPricePerBrandServiceImpl   implements MaxPricePerBrandService {

    @Autowired
    private MaxPricePerBrandRepository maxPricePerBrandRepository;

    @Override
    public List<MaxPricePerBrand> getAllMaxPricePerBrand() {
        return maxPricePerBrandRepository.findAll();
    }
}
