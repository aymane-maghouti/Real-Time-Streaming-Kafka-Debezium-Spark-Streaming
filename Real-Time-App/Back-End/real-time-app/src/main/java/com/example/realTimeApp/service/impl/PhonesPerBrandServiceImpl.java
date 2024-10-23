package com.example.realTimeApp.service.impl;

import com.example.realTimeApp.models.PhonesPerBrand;
import com.example.realTimeApp.repository.PhonesPerBrandRepository;
import com.example.realTimeApp.service.PhonesPerBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhonesPerBrandServiceImpl implements PhonesPerBrandService {

    @Autowired
    private PhonesPerBrandRepository phonesPerBrandRepository;

    @Override
    public List<PhonesPerBrand> getAllPhonesPerBrand() {
        return phonesPerBrandRepository.findAll();
    }
}
