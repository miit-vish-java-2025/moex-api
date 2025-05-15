package ru.vish.moex_api.client;

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
        JsonNode jsonNodeData = mapper.readTree(responseBody).get("data");
        for (JsonNode jsonNodeDatum : jsonNodeData){
            String jsonNodeId = jsonNodeDatum.get("id").textValue();
            if (!"marketdata".equals(jsonNodeId)){
                continue;
            }
            JsonNode jsonNodeRows = jsonNodeDatum.get("rows").get("row");
            for (JsonNode obj : jsonNodeRows){
                String jsonNodeBoardId = obj.get("BOARDID").textValue();
                if (!"TQBR".equals(jsonNodeBoardId)){
                    continue;
                }
                String jsonNodeLastPriceStr = obj.get("LAST").textValue();
                BigDecimal jsonNodeLastPrice = new BigDecimal(jsonNodeLastPriceStr);
                return jsonNodeLastPrice;
            }
        }

        throw new IllegalArgumentException("Failed to find last price!");
    }
}
