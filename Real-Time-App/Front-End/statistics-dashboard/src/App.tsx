import React, { useState, useEffect } from 'react';
import './App.css';
import { getStatisticsData } from './services/api';
import { StatisticsAnalysis } from './types/StatisticsAnalysis';
import KPI from './components/KPI';
import HorizontalBarChart from './components/HorizentalBarChart';
import StackedHistogram from './components/StackedHistogram';

const App: React.FC = () => {
  const [statistics, setStatistics] = useState<StatisticsAnalysis | null>(null);

  useEffect(() => {
    const fetchData = async () => {
      const data = await getStatisticsData();
      setStatistics(data);
    };

    fetchData(); 
    const interval = setInterval(fetchData, 5000); 

    return () => clearInterval(interval);
  }, []);

  if (!statistics) return <p>Loading...</p>; 

  return (
    <div className="App">
      <div className="header-section">
        <div className="developer">
          Developed by <span>A</span>ymane-<span>MG</span>
        </div>
        <div className="last-updated">
          Last Updated: {new Date(statistics.updatedAt).toLocaleString()}
        </div>
      </div>

      <h1 className="title">Real-Time Smartphone Data Analysis Dashboard</h1>

         <div className="kpi-section">
        <KPI label="Total Phones" value={statistics.totalPhones -1} />
        <KPI label="Max Price" value={`${statistics.maxPrice} MAD`} />
        <KPI label="Max Screen Size" value={`${statistics.maxScreenSize} pouces`} />
        <KPI label="Max RAM" value={`${statistics.maxRam} GB`} />
        <KPI label="Max ROM" value={`${statistics.maxRom} GB`} />
        <KPI label="Max Battery" value={`${statistics.maxBattery} mA`} />
      </div>


  <div className="charts-section">


      <div className="chart-card bar-chart">
        <h2>Total Phones Per Brand</h2>
        <HorizontalBarChart data={statistics.phonesPerBrand} title="Phones Per Brand" xKey="brand" yKey="totalPhones" />
      </div>
      <div className="chart-card bar-chart">
        <h2>Max RAM Per Brand</h2>
        <HorizontalBarChart data={statistics.maxRamPerBrand} title="Max RAM Per Brand" xKey="brand" yKey="maxRam" />
      </div>
      <div className="chart-card bar-chart">
      <h2>Max Battery Per Brand</h2>
        <HorizontalBarChart data={statistics.maxBatteryPerBrand} title="Max Battery Per Brand" xKey="brand" yKey="maxBattery" />
      </div>

      <div className="chart-card bar-chart">
      <h2>Max Price Per Brand</h2>
        <HorizontalBarChart data={statistics.maxPricePerBrand} title="Max Price Per Brand" xKey="brand" yKey="maxPrice" />
      </div>

      <div className="chart-card stacked-histogram">
      <h2>Toatl Phones Per SIM Type</h2>
        <StackedHistogram data={statistics.phonesPerSimType} title="Toatl Phones Per SIM Type" xKey="simType" yKey="totalPhones" />
      </div>

      <div className="chart-card stacked-histogram">
      <h2>Max Price Per SIM Type</h2>
        <StackedHistogram data={statistics.maxPricePerSimType} title="Max Price Per SIM Type" xKey="simType" yKey="maxPrice" />
      </div>

      <div className="chart-card stacked-histogram">
      <h2>Max Price Per SIM Type</h2>
        <StackedHistogram data={statistics.maxPricePerSimType} title="Max Price Per SIM Type" xKey="simType" yKey="maxPrice" />
      </div>

      <div className="chart-card stacked-histogram">
      <h2>Max ROM Per SIM Type</h2>
        <StackedHistogram data={statistics.maxRomPerSimType} title="Max ROM Per SIM Type" xKey="simType" yKey="maxRom" />
      </div>

      <div className="chart-card stacked-histogram">
        <h2>Max Screen Size Per SIM Type</h2>
        <StackedHistogram data={statistics.maxScreenSizePerSimType} title="Max Screen Size Per SIM Type" xKey="simType" yKey="maxScreenSize" />
      </div>
    </div>

  </div>
  );
};

export default App;
