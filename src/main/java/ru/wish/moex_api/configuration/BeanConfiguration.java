package ru.wish.moex_api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.wish.moex_api.client.MoexApiClient;
import ru.wish.moex_api.service.DataAggregationService;
import ru.wish.moex_api.service.MoexPollingService;

@Configuration
public class BeanConfiguration {
    @Bean
    public DataAggregationService dataAggregationService() {
        return new DataAggregationService();
    }

    @Bean
    public MoexPollingService moexPollingService(MoexApiClient moexClient, DataAggregationService aggService) {
        return new MoexPollingService(moexClient, aggService);
    }
}
