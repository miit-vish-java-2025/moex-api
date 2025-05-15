package ru.vish.moex_api.kafka.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SharePricesKafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(SharePricesKafkaConsumer.class);

    @KafkaListener(topics = "share-prices")
    public void consume(String message) {
        logger.info("Received kafka message: {}", message);
    }
}
