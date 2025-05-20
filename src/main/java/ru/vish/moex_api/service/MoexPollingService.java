package ru.vish.moex_api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import ru.vish.moex_api.client.MoexApiClient;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//@Service
public class MoexPollingService {
    private MoexApiClient moexClient;
    private ExecutorService executor = Executors.newFixedThreadPool(2);
    private final DataAggregationService aggService;
    private final Logger logger = LoggerFactory.getLogger(MoexPollingService.class);

    public MoexPollingService(MoexApiClient moexClient, DataAggregationService aggService){
        this.moexClient = moexClient;
        this.aggService = aggService;
    }
    @Scheduled(fixedRate = 10000)
    private void run() {
        List<String> tickers = List.of("SBER", "LKOH", "MGNT");
        for (String ticker : tickers) {
            executor.submit(() -> parsePrice(ticker));
        }
    }

    private void parsePrice(String ticker) {
        try {
            BigDecimal price = moexClient.getLastPriceForTicker(ticker);
            logger.info("Price for {}: {} RUB", ticker, price.toString());
            // TODO: invoke aggService after we add multi-ticker support there
        } catch (Exception e) {
            logger.error("Failed to poll {} price", ticker, e);
        }
    }
}
