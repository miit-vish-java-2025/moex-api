package ru.vish.moex_api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import ru.vish.moex_api.client.MoexApiClient;

import java.math.BigDecimal;

//@Service
public class MoexPollingService {
    private MoexApiClient moexClient;
    private final DataAggregationService aggService;
    private final Logger logger = LoggerFactory.getLogger(MoexPollingService.class);

    public MoexPollingService(MoexApiClient moexClient, DataAggregationService aggService){
        this.moexClient = moexClient;
        this.aggService = aggService;
    }
    @Scheduled(fixedRate = 10000)
    private void run() {
        parsePrice("SBER");
    }

    private void parsePrice(String ticker) {
        try {
            BigDecimal price = moexClient.getLastPriceForTicker(ticker);
            logger.info("Price for {}: {} RUB", ticker, price.toString());
        } catch (Exception e) {
            logger.error("Failed to poll {} price", ticker, e);
        }
    }
}
