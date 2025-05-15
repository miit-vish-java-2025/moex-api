package ru.vish.moex_api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nonnull;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.vish.moex_api.kafka.model.SharePriceKafkaMessage;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public void publish(@Nonnull BigDecimal price) {
        SharePriceKafkaMessage message = SharePriceKafkaMessage.builder()
                .timestamp(Instant.now())
                .price(price)
                .build();
        String messageString = objectMapper.writeValueAsString(message);
        kafkaTemplate.send("share-prices", messageString);
    }
}
