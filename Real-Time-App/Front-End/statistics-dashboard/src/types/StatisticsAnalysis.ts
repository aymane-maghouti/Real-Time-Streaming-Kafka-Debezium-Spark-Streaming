export interface StatisticsAnalysis {
    totalPhones: number;
    maxPrice: number;
    maxScreenSize: number;
    maxRam: number;
    maxRom: number;
    maxBattery: number;
    updatedAt: string;
  
    phonesPerBrand: BrandPhones[];
    phonesPerSimType: SimTypePhones[];
    maxPricePerBrand: BrandMaxPrice[];
    maxPricePerSimType: SimTypeMaxPrice[];
    maxRamPerBrand: BrandMaxRam[];
    maxRomPerSimType: SimTypeMaxRom[];
    maxBatteryPerBrand: BrandMaxBattery[];
    maxScreenSizePerSimType: SimTypeMaxScreenSize[];
  }
  
  export interface BrandPhones {
    brand: string;
    totalPhones: number;
  }
  
  export interface SimTypePhones {
    simType: string;
    totalPhones: number;
  }
  
  export interface BrandMaxPrice {
    brand: string;
    maxPrice: number;
  }
  
  export interface SimTypeMaxPrice {
    simType: string;
    maxPrice: number;
  }
  
  export interface BrandMaxRam {
    brand: string;
    maxRam: number;
  }
  
  export interface SimTypeMaxRom {
    simType: string;
    maxRom: number;
  }
  
  export interface BrandMaxBattery {
    brand: string;
    maxBattery: number;
  }
  
  export interface SimTypeMaxScreenSize {
    simType: string;
    maxScreenSize: number;
  }
  
  
  
  
  