package ru.wish.moex_api.controller;

import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/mean")
    public String getMean() {
        return "mean";
    }
}
