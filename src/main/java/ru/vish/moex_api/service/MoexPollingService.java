package ru.vish.moex_api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vish.moex_api.client.MoexApiClient;

import java.math.BigDecimal;

//@Service
public class MoexPollingService {
    private MoexApiClient moexClient;
    private final DataAggregationService aggService;
    private final KafkaProducerService kafkaProducerService;
    private final Logger logger = LoggerFactory.getLogger(MoexPollingService.class);

    public MoexPollingService(MoexApiClient moexClient, DataAggregationService aggService, KafkaProducerService kafkaProducerService){
        this.moexClient = moexClient;
        this.aggService = aggService;
        this.kafkaProducerService = kafkaProducerService;
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
                kafkaProducerService.publish(price);
            } catch (Exception e) {
                logger.error("Failed to poll moex price", e);
            }
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
