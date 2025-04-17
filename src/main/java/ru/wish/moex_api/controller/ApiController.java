package ru.wish.moex_api.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.wish.moex_api.service.DataAggregationService;

@RestController
public class ApiController {
    private DataAggregationService dataAggregationService;

    public ApiController(DataAggregationService dataAggregationService) {
        this.dataAggregationService = dataAggregationService;
    }

    @GetMapping("/api/mean")
    public String getMean() {
        return String.valueOf(dataAggregationService.getMean());
    }
}
