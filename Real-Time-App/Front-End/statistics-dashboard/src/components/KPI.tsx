import React from 'react';

interface KPIProps {
  label: string;
  value: number | string;
}

const KPI: React.FC<KPIProps> = ({ label, value }) => {
  return (
    <div className="kpi-card">
      <h4>{label}</h4>
      <p>{value}</p>
    </div>
  );
};

export default KPI;

