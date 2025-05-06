package ru.wish.moex_api.service;

import jakarta.annotation.Nonnull;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import ru.wish.moex_api.entity.PriceHistoryEntity;
import ru.wish.moex_api.repository.PriceHistoryRepository;

import java.math.BigDecimal;
import java.time.Instant;

//@Service
public class DataAggregationService {
    private DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(100);
    private PriceHistoryRepository priceHistoryRepository;

    public DataAggregationService(PriceHistoryRepository priceHistoryRepository) {
        this.priceHistoryRepository = priceHistoryRepository;
    }

    public void addValue(@Nonnull BigDecimal price) {
        descriptiveStatistics.addValue(price.doubleValue());
        PriceHistoryEntity entity = new PriceHistoryEntity();
        entity.setPrice(price);
        entity.setTimestamp(Instant.now());
        priceHistoryRepository.save(entity);
    }

    public double getMean() {
        return descriptiveStatistics.getMean();
    }
}
