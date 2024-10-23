package com.example.realTimeApp.service.impl;

import com.example.realTimeApp.models.MaxRomPerSimType;
import com.example.realTimeApp.repository.MaxRomPerSimTypeRepository;
import com.example.realTimeApp.service.MaxRomPerSimTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaxRomPerSimTypeServiceImpl implements MaxRomPerSimTypeService {

    @Autowired
    private MaxRomPerSimTypeRepository maxRomPerSimTypeRepository;

    @Override
    public List<MaxRomPerSimType> getAllMaxRomPerSimType() {
        return maxRomPerSimTypeRepository.findAll();
    }
}