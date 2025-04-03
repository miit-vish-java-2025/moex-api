package ru.wish.moex_api.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoexApiClientTest {
    @Autowired
    MoexApiClient moexApiClient;
    @Test
    void getLastPriceForTicker() throws JsonProcessingException {
        BigDecimal price = moexApiClient.getLastPriceForTicker("SBER");
        Assertions.assertThat(price.intValue()).isBetween(100, 500);
    }
}
