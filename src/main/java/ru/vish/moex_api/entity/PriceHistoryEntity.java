package ru.vish.moex_api.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Generated;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "price_history")
public class PriceHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Instant timestamp;
    private String ticker;
    private BigDecimal price;
}
