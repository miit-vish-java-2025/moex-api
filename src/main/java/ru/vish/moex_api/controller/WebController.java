package ru.vish.moex_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.vish.moex_api.service.DataAggregationService;

@Controller
public class WebController {

    private final DataAggregationService dataAggregationService;

    public WebController(DataAggregationService dataAggregationService) {
        this.dataAggregationService = dataAggregationService;
    }

    @GetMapping("/mean")
    public String getMean(@RequestParam String ticker, Model model) {
        model.addAttribute("mean", dataAggregationService.getMean(ticker));
        model.addAttribute("ticker", ticker);
        return "mean";
    }
}
