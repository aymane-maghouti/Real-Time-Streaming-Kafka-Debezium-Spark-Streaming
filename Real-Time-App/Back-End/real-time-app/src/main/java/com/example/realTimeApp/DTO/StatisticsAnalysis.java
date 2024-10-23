package com.example.realTimeApp.DTO;

import lombok.*;

import java.util.List;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticsAnalysis {

    private Integer totalPhones;
    private Double maxPrice;
    private Double maxScreenSize;
    private Double maxRam;
    private Double maxRom;
    private Double maxBattery;
    private LocalDateTime updatedAt;

    private List<BrandPhonesDTO> phonesPerBrand;
    private List<SimTypePhonesDTO> phonesPerSimType;
    private List<BrandMaxPriceDTO> maxPricePerBrand;
    private List<SimTypeMaxPriceDTO> maxPricePerSimType;
    private List<BrandMaxRamDTO> maxRamPerBrand;
    private List<SimTypeMaxRomDTO> maxRomPerSimType;
    private List<BrandMaxBatteryDTO> maxBatteryPerBrand;
    private List<SimTypeMaxScreenSizeDTO> maxScreenSizePerSimType;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class BrandPhonesDTO {
        private String brand;
        private Integer totalPhones;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class SimTypePhonesDTO {
        private String simType;
        private Integer totalPhones;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class BrandMaxPriceDTO {
        private String brand;
        private Double maxPrice;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class SimTypeMaxPriceDTO {
        private String simType;
        private Double maxPrice;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class BrandMaxRamDTO {
        private String brand;
        private Double maxRam;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class SimTypeMaxRomDTO {
        private String simType;
        private Double maxRom;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class BrandMaxBatteryDTO {
        private String brand;
        private Double maxBattery;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class SimTypeMaxScreenSizeDTO {
        private String simType;
        private Double maxScreenSize;
    }

}