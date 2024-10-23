package com.example.realTimeApp.mapper;

import com.example.realTimeApp.DTO.StatisticsAnalysis;
import com.example.realTimeApp.models.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatisticsAnalysisMapper {

    public StatisticsAnalysis toDTO(
            StatisticsSummary statisticsSummary,
            List<PhonesPerBrand> phonesPerBrandList,
            List<PhonesPerSimType> phonesPerSimTypeList,
            List<MaxPricePerBrand> maxPricePerBrandList,
            List<MaxPricePerSimType> maxPricePerSimTypeList,
            List<MaxRamPerBrand> maxRamPerBrandList,
            List<MaxRomPerSimType> maxRomPerSimTypeList,
            List<MaxBatteryPerBrand> maxBatteryPerBrandList,
            List<MaxScreenSizePerSimType> maxScreenSizePerSimTypeList
    ) {
        return StatisticsAnalysis.builder()
                .totalPhones(statisticsSummary.getTotalPhones())
                .maxPrice(statisticsSummary.getMaxPrice())
                .maxScreenSize(statisticsSummary.getMaxScreenSize())
                .maxRam(statisticsSummary.getMaxRam())
                .maxRom(statisticsSummary.getMaxRom())
                .maxBattery(statisticsSummary.getMaxBattery())
                .updatedAt(statisticsSummary.getUpdatedAt())
                .phonesPerBrand(mapBrandPhonesDTOList(phonesPerBrandList))
                .phonesPerSimType(mapSimTypePhonesDTOList(phonesPerSimTypeList))
                .maxPricePerBrand(mapBrandMaxPriceDTOList(maxPricePerBrandList))
                .maxPricePerSimType(mapSimTypeMaxPriceDTOList(maxPricePerSimTypeList))
                .maxRamPerBrand(mapBrandMaxRamDTOList(maxRamPerBrandList))
                .maxRomPerSimType(mapSimTypeMaxRomDTOList(maxRomPerSimTypeList))
                .maxBatteryPerBrand(mapBrandMaxBatteryDTOList(maxBatteryPerBrandList))
                .maxScreenSizePerSimType(mapSimTypeMaxScreenSizeDTOList(maxScreenSizePerSimTypeList))
                .build();
    }

    private List<StatisticsAnalysis.BrandPhonesDTO> mapBrandPhonesDTOList(List<PhonesPerBrand> phonesPerBrandList) {
        return phonesPerBrandList.stream()
                .map(phonesPerBrand -> new StatisticsAnalysis().new BrandPhonesDTO(
                        phonesPerBrand.getBrand(),
                        phonesPerBrand.getTotalPhones()))
                .collect(Collectors.toList());
    }

    private List<StatisticsAnalysis.SimTypePhonesDTO> mapSimTypePhonesDTOList(List<PhonesPerSimType> phonesPerSimTypeList) {
        return phonesPerSimTypeList.stream()
                .map(phonesPerSimType -> new StatisticsAnalysis().new SimTypePhonesDTO(
                        phonesPerSimType.getSimType(),
                        phonesPerSimType.getTotalPhones()))
                .collect(Collectors.toList());
    }

    private List<StatisticsAnalysis.BrandMaxPriceDTO> mapBrandMaxPriceDTOList(List<MaxPricePerBrand> maxPricePerBrandList) {
        return maxPricePerBrandList.stream()
                .map(maxPricePerBrand -> new StatisticsAnalysis().new BrandMaxPriceDTO(
                        maxPricePerBrand.getBrand(),
                        maxPricePerBrand.getMaxPrice()))
                .collect(Collectors.toList());
    }

    private List<StatisticsAnalysis.SimTypeMaxPriceDTO> mapSimTypeMaxPriceDTOList(List<MaxPricePerSimType> maxPricePerSimTypeList) {
        return maxPricePerSimTypeList.stream()
                .map(maxPricePerSimType -> new StatisticsAnalysis().new SimTypeMaxPriceDTO(
                        maxPricePerSimType.getSimType(),
                        maxPricePerSimType.getMaxPrice()))
                .collect(Collectors.toList());
    }

    private List<StatisticsAnalysis.BrandMaxRamDTO> mapBrandMaxRamDTOList(List<MaxRamPerBrand> maxRamPerBrandList) {
        return maxRamPerBrandList.stream()
                .map(maxRamPerBrand -> new StatisticsAnalysis().new BrandMaxRamDTO(
                        maxRamPerBrand.getBrand(),
                        maxRamPerBrand.getMaxRam()))
                .collect(Collectors.toList());
    }

    private List<StatisticsAnalysis.SimTypeMaxRomDTO> mapSimTypeMaxRomDTOList(List<MaxRomPerSimType> maxRomPerSimTypeList) {
        return maxRomPerSimTypeList.stream()
                .map(maxRomPerSimType -> new StatisticsAnalysis().new SimTypeMaxRomDTO(
                        maxRomPerSimType.getSimType(),
                        maxRomPerSimType.getMaxRom()))
                .collect(Collectors.toList());
    }

    private List<StatisticsAnalysis.BrandMaxBatteryDTO> mapBrandMaxBatteryDTOList(List<MaxBatteryPerBrand> maxBatteryPerBrandList) {
        return maxBatteryPerBrandList.stream()
                .map(maxBatteryPerBrand -> new StatisticsAnalysis().new BrandMaxBatteryDTO(
                        maxBatteryPerBrand.getBrand(),
                        maxBatteryPerBrand.getMaxBattery()))
                .collect(Collectors.toList());
    }

    private List<StatisticsAnalysis.SimTypeMaxScreenSizeDTO> mapSimTypeMaxScreenSizeDTOList(List<MaxScreenSizePerSimType> maxScreenSizePerSimTypeList) {
        return maxScreenSizePerSimTypeList.stream()
                .map(maxScreenSizePerSimType -> new StatisticsAnalysis().new SimTypeMaxScreenSizeDTO(
                        maxScreenSizePerSimType.getSimType(),
                        maxScreenSizePerSimType.getMaxScreenSize()))
                .collect(Collectors.toList());
    }
}
