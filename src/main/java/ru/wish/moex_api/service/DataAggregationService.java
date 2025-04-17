package ru.wish.moex_api.service;

import jakarta.annotation.Nonnull;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

//@Service
public class DataAggregationService {
    private DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(100);

    public void addValue(@Nonnull BigDecimal price) {
        descriptiveStatistics.addValue(price.doubleValue());
    }

    public double getMean() {
        return descriptiveStatistics.getMean();
    }
}
