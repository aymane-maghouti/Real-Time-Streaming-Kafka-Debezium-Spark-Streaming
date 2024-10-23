import React from 'react';
import { Bar } from 'react-chartjs-2';
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Tooltip,
  Legend
} from 'chart.js';
import ChartDataLabels from 'chartjs-plugin-datalabels';

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Tooltip,
  Legend,
  ChartDataLabels
);

interface BarChartProps {
  data: { [key: string]: any }[];
  title: string;
  xKey: string; 
  yKey: string; 
}

const HorizontalBarChart: React.FC<BarChartProps> = ({ data, title, xKey, yKey }) => {
  const chartData = {
    labels: data.map(item => item[xKey]),
    datasets: [
      {
        label: title,
        data: data.map(item => item[yKey]), 
        backgroundColor: [
          'rgba(255, 99, 132, 0.6)',
          'rgba(54, 162, 235, 0.6)',
          'rgba(255, 206, 86, 0.6)',
          'rgba(75, 192, 192, 0.6)',
          'rgba(153, 102, 255, 0.6)',
          'rgba(255, 159, 64, 0.6)'
        ],
      },
    ],
  };

  const chartOptions = {
    responsive: true,
    maintainAspectRatio: false, 
    indexAxis: 'y' as const,
    scales: {
      x: {
        beginAtZero: true, 
        grid: {
          color: 'rgba(255, 255, 255, 0.1)',
        },
        ticks: {
          color: '#fff', 
        },
      },
      y: {
        ticks: {
          color: '#fff', 
        },
      },
    },
    plugins: {
      legend: {
        display: false, 
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
    <div>
      <div style={{ position: 'relative', width: '100%', height: '250px' }}>
        <Bar data={chartData} options={chartOptions} />
      </div>
    </div>
  );
};

export default HorizontalBarChart;
