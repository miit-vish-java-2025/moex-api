package ru.wish.moex_api.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MoexApiClientTest {
    @Autowired
    MoexApiClient moexApiClient;
    @Test
    void getLastPriceForTicker() {
        moexApiClient.getLastPriceForTicker("SBER");
    }
}