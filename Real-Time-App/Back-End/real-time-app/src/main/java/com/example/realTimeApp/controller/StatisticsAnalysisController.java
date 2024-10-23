package com.example.realTimeApp.controller;

import com.example.realTimeApp.DTO.StatisticsAnalysis;
import com.example.realTimeApp.models.*;
import com.example.realTimeApp.mapper.StatisticsAnalysisMapper;
import com.example.realTimeApp.path.ApiPaths;
import com.example.realTimeApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.BASE_STATISTICS_PATH)
@CrossOrigin(origins = "http://localhost:3000/")
public class StatisticsAnalysisController {

    @Autowired
    private StatisticsSummaryService statisticsSummaryService;

    @Autowired
    private PhonesPerBrandService phonesPerBrandService;

    @Autowired
    private PhonesPerSimTypeService phonesPerSimTypeService;

    @Autowired
    private MaxPricePerBrandService maxPricePerBrandService;

    @Autowired
    private MaxPricePerSimTypeService maxPricePerSimTypeService;

    @Autowired
    private MaxRamPerBrandService maxRamPerBrandService;

    @Autowired
    private MaxRomPerSimTypeService maxRomPerSimTypeService;

    @Autowired
    private MaxBatteryPerBrandService maxBatteryPerBrandService;

    @Autowired
    private MaxScreenSizePerSimTypeService maxScreenSizePerSimTypeService;

    @Autowired
    private StatisticsAnalysisMapper statisticsAnalysisMapper;


    @GetMapping(ApiPaths.ANALYSIS_PATH)
    public ResponseEntity<StatisticsAnalysis> getStatisticsAnalysis() {
        StatisticsSummary statisticsSummary = statisticsSummaryService.getAllStatisticsSummaries();
        List<PhonesPerBrand> phonesPerBrandList = phonesPerBrandService.getAllPhonesPerBrand();
        List<PhonesPerSimType> phonesPerSimTypeList = phonesPerSimTypeService.getAllPhonesPerSimType();
        List<MaxPricePerBrand> maxPricePerBrandList = maxPricePerBrandService.getAllMaxPricePerBrand();
        List<MaxPricePerSimType> maxPricePerSimTypeList = maxPricePerSimTypeService.getAllMaxPricePerSimType();
        List<MaxRamPerBrand> maxRamPerBrandList = maxRamPerBrandService.getAllMaxRamPerBrand();
        List<MaxRomPerSimType> maxRomPerSimTypeList = maxRomPerSimTypeService.getAllMaxRomPerSimType();
        List<MaxBatteryPerBrand> maxBatteryPerBrandList = maxBatteryPerBrandService.getAllMaxBatteryPerBrand();
        List<MaxScreenSizePerSimType> maxScreenSizePerSimTypeList = maxScreenSizePerSimTypeService.getAllMaxScreenSizePerSimType();

        StatisticsAnalysis statisticsAnalysisDTO = statisticsAnalysisMapper.toDTO(
                statisticsSummary,
                phonesPerBrandList,
                phonesPerSimTypeList,
                maxPricePerBrandList,
                maxPricePerSimTypeList,
                maxRamPerBrandList,
                maxRomPerSimTypeList,
                maxBatteryPerBrandList,
                maxScreenSizePerSimTypeList
        );

        return ResponseEntity.ok(statisticsAnalysisDTO);
    }
}
