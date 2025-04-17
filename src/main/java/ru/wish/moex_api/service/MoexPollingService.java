package ru.wish.moex_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.wish.moex_api.client.MoexApiClient;

import java.math.BigDecimal;

//@Service
public class MoexPollingService {
    private MoexApiClient moexClient;
    private DataAggregationService aggService;
    private final Logger logger = LoggerFactory.getLogger(MoexPollingService.class);

    public MoexPollingService(MoexApiClient moexClient, DataAggregationService aggService){
        this.moexClient = moexClient;
        this.aggService = aggService;
        new Thread(() -> {
            this.run();
        }).start();
    }
    private void run() {
        while (true) {
            try {
                String ticker = "SBER";
                BigDecimal price = moexClient.getLastPriceForTicker(ticker);
                logger.info("Price for {}: {} RUB", ticker, price.toString());
                aggService.addValue(price);
                Thread.sleep(1000);
            } catch (Exception e) {
                logger.error("Failed to poll moex price", e);
            }
        }
    }
}
