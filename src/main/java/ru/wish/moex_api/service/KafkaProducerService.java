package ru.wish.moex_api.service;

import jakarta.annotation.Nonnull;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.wish.moex_api.kafka.model.SharePriceKafkaMessage;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, SharePriceKafkaMessage> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, SharePriceKafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(@Nonnull BigDecimal price) {
        SharePriceKafkaMessage message = SharePriceKafkaMessage.builder()
                .timestamp(Instant.now())
                .price(price)
                .build();
        kafkaTemplate.send("share-prices", message);
    }
}
