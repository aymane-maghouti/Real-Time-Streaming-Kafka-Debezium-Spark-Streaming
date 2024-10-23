import axios from 'axios';
import { StatisticsAnalysis } from '../types/StatisticsAnalysis';

const BASE_URL = 'http://localhost:8089/api/v1/statistics/analysis';

export const getStatisticsData = async (): Promise<StatisticsAnalysis | null> => {
  try {
    const response = await axios.get(BASE_URL);
    return response.data;
  } catch (error) {
    console.error('Error fetching statistics data:', error);
    return null;
  }
};
