package ru.wish.moex_api.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "price_history")
public class PriceHistoryEntity {
    @Id
    private long id;
    private Instant timestamp;
    private BigDecimal price;
}
