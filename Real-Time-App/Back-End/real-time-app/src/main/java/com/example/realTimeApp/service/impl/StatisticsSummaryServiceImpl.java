package com.example.realTimeApp.service.impl;

import com.example.realTimeApp.models.StatisticsSummary;
import com.example.realTimeApp.repository.StatisticsSummaryRepository;
import com.example.realTimeApp.service.StatisticsSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatisticsSummaryServiceImpl implements StatisticsSummaryService {

    @Autowired
    private StatisticsSummaryRepository statisticsSummaryRepository;

    @Override
    public StatisticsSummary getAllStatisticsSummaries() {
        return statisticsSummaryRepository.findAll().get(0);
    }
}
