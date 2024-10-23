package com.example.realTimeApp.repository;


import com.example.realTimeApp.models.StatisticsSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsSummaryRepository extends JpaRepository<StatisticsSummary, Long> {
}
