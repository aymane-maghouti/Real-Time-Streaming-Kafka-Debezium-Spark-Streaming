import React from 'react';
import { Bar } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
} from 'chart.js';

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

interface StackedHistogramProps {
  data: { [key: string]: any }[]; 
  title: string;
  xKey: string; 
  yKey: string; 
}

const StackedHistogram: React.FC<StackedHistogramProps> = ({ data, title, xKey, yKey }) => {
  const chartData = {
    labels: data.map(item => item[xKey]), // Dynamically use the xKey for labels
    datasets: [
      {
        label: title,
        data: data.map(item => item[yKey]), 
        backgroundColor: 'rgba(153, 102, 255, 0.6)',
      },
    ],
  };

  const chartOptions = {
    responsive: true,
    maintainAspectRatio: false, 
    scales: {
      x: { 
        stacked: true,
        grid: {
          color: 'rgba(255, 255, 255, 0.1)',
        },
        ticks: {
          color: '#fff', 
        },
      },
      y: { 
        stacked: true,
        grid: {
          color: 'rgba(255, 255, 255, 0.1)', 
        },
        ticks: {
          color: '#fff', 
        },
      },
    },
    plugins: {
      legend: {
        display: false, 
      },
      title: {
        display: false,
        text: title,
        color: '#fff', 
        font: {
          size: 18,
          weight: 'bold' as const,
        },
      },
      datalabels: {
        anchor: 'end' as const,
        align: 'center' as const, 
        formatter: (value: number) => value.toLocaleString(),
        color: '#fff', 
        font: {
          weight: 'bold' as const, 
        },
      },
    },
  };

  return (
    <div style={{ position: 'relative', width: '100%', height: '250px' }}>
      <Bar data={chartData} options={chartOptions} />
    </div>
  );
};

export default StackedHistogram;
