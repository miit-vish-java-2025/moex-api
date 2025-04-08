package ru.wish.moex_api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.wish.moex_api.client.MoexApiClient;

@Service
public class MoexPollingService {
    private MoexApiClient moexClient;
    private final Logger logger = LoggerFactory.getLogger(MoexPollingService.class);

    public MoexPollingService(MoexApiClient moexClient){
        this.moexClient = moexClient;
        new Thread(() -> {
            this.run();
        }).start();

    }
    private void run() {
        try {
            moexClient.getLastPriceForTicker("SBER");
        } catch (Exception e){
            logger.error("Failed to poll moex price", e);
        }
    }
}
