package ru.wish.moex_api.service;

import org.springframework.stereotype.Service;
import ru.wish.moex_api.client.MoexApiClient;

@Service
public class MoexPollingService {
    private MoexApiClient moexClient;

    public MoexPollingService(MoexApiClient moexClient){
        this.moexClient = moexClient;
    }
}
