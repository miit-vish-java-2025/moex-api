package ru.wish.moex_api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.wish.moex_api.service.DataAggregationService;

@Configuration
public class BeanConfiguration {
    @Bean
    public DataAggregationService dataAggregationService() {
        return new DataAggregationService();
    }
}
