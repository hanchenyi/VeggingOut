package com.example.demo.external;

import com.example.demo.constant.CoinType;
import com.example.demo.constant.RateType;
import com.example.demo.external.model.RateData;
import com.example.demo.external.model.TickerData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TickerListener {

    @Autowired
    RestTemplate restTemplate;

    @Value("${external.ticker.uri}")
    String tickerUri;

    public TickerData getTickerData(String coinType) {
        String tickerType = CoinType.valueOf(coinType).getTickerType();
        String URI = String.format(tickerUri, tickerType);
        TickerData data = new TickerData();
        ResponseEntity<String> result = null;
        JsonNode node = null;
        try {
            result = restTemplate.getForEntity(new URI(URI), String.class);
            node = new ObjectMapper().readTree(result.getBody());
            data.setTickerCode(coinType);
            data.setRateData(getRateData(node));
            data.setTimeStamp(node.get("time").get("updatedISO").textValue());
        } catch (URISyntaxException | JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }

    private List<RateData> getRateData(JsonNode node) {
        List<RateData> rateDataList = new ArrayList<>();
        for (RateType rateType : RateType.values()) {
            rateDataList.add(new RateData(rateType.name(), node.get("bpi").get(rateType.name()).get("rate").textValue()));
        }
        return rateDataList;
    }
}
