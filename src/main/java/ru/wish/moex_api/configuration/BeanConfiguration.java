package ru.wish.moex_api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.wish.moex_api.client.MoexApiClient;
import ru.wish.moex_api.repository.PriceHistoryRepository;
import ru.wish.moex_api.service.DataAggregationService;
import ru.wish.moex_api.service.KafkaProducerService;
import ru.wish.moex_api.service.MoexPollingService;

@Configuration
public class BeanConfiguration {
    @Bean
    public DataAggregationService dataAggregationService(PriceHistoryRepository priceHistoryRepository) {
        return new DataAggregationService(priceHistoryRepository);
    }

    @Bean
    public MoexPollingService moexPollingService(MoexApiClient moexClient, DataAggregationService aggService, KafkaProducerService kafkaProducerService) {
        return new MoexPollingService(moexClient, aggService, kafkaProducerService);
    }
}
