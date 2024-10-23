package com.example.realTimeApp.service.impl;

import com.example.realTimeApp.models.MaxPricePerSimType;
import com.example.realTimeApp.repository.MaxPricePerSimTypeRepository;
import com.example.realTimeApp.service.MaxPricePerSimTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaxPricePerSimTypeServiceImpl implements MaxPricePerSimTypeService {

    @Autowired
    private MaxPricePerSimTypeRepository maxPricePerSimTypeRepository;

    @Override
    public List<MaxPricePerSimType> getAllMaxPricePerSimType() {
        return maxPricePerSimTypeRepository.findAll();
    }
}