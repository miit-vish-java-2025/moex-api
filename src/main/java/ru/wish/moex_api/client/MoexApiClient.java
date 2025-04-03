package ru.wish.moex_api.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class MoexApiClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getLastPriceForTicker(String ticker) {
        String url = "https://iss.moex.com/iss/engines/stock/markets/shares/securities/" + ticker + ".xml";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return null;
    }
}
