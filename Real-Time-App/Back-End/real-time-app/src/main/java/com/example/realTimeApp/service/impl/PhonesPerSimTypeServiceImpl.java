package com.example.realTimeApp.service.impl;

import com.example.realTimeApp.models.PhonesPerSimType;
import com.example.realTimeApp.repository.PhonesPerSimTypeRepository;
import com.example.realTimeApp.service.PhonesPerSimTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhonesPerSimTypeServiceImpl implements PhonesPerSimTypeService {

    @Autowired
    private PhonesPerSimTypeRepository phonesPerSimTypeRepository;

    @Override
    public List<PhonesPerSimType> getAllPhonesPerSimType() {
        return phonesPerSimTypeRepository.findAll();
    }
}