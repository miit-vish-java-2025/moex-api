package ru.wish.moex_api.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class MoexApiClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new XmlMapper();

    public BigDecimal getLastPriceForTicker(String ticker) throws JsonProcessingException {
        String url = "https://iss.moex.com/iss/engines/stock/markets/shares/securities/" + ticker + ".xml";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String responseBody = response.getBody();
        JsonNode jsonNode = mapper.readTree(responseBody);
        return null;
    }
}
