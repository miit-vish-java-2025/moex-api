package ru.vish.moex_api.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.vish.moex_api.kafka.model.SharePriceKafkaMessage;

@Service
public class SharePricesKafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(SharePricesKafkaConsumer.class);
    private final ObjectMapper objectMapper;

    public SharePricesKafkaConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @KafkaListener(topics = "share-prices")
    public void consume(ConsumerRecord<String, String> message) {
        String messageBody = message.value();

        SharePriceKafkaMessage parsedMessage = objectMapper.readValue(messageBody, SharePriceKafkaMessage.class);

        logger.info("Received kafka message: {}", parsedMessage);
    }
}
