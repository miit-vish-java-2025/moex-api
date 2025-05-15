package ru.wish.moex_api.kafka.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class SharePriceKafkaMessage {
    private Instant timestamp;
    private BigDecimal price;
}
