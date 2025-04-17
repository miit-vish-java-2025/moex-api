package ru.wish.moex_api.controller;

import jdk.jfr.Category;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.wish.moex_api.service.DataAggregationService;

@Controller
public class WebController {

    private final DataAggregationService dataAggregationService;

    public WebController(DataAggregationService dataAggregationService) {
        this.dataAggregationService = dataAggregationService;
    }

    @GetMapping("/mean")
    public String getMean(Model model) {
        model.addAttribute("mean", dataAggregationService.getMean());
        return "mean";
    }
}
