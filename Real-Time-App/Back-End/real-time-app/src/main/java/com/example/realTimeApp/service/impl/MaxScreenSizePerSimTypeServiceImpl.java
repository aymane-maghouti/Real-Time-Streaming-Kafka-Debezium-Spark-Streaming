package com.example.realTimeApp.service.impl;

import com.example.realTimeApp.models.MaxScreenSizePerSimType;
import com.example.realTimeApp.repository.MaxScreenSizePerSimTypeRepository;
import com.example.realTimeApp.service.MaxScreenSizePerSimTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaxScreenSizePerSimTypeServiceImpl implements MaxScreenSizePerSimTypeService {

    @Autowired
    private MaxScreenSizePerSimTypeRepository maxScreenSizePerSimTypeRepository;

    @Override
    public List<MaxScreenSizePerSimType> getAllMaxScreenSizePerSimType() {
        return maxScreenSizePerSimTypeRepository.findAll();
    }
}