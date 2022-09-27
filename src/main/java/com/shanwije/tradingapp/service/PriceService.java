package com.shanwije.tradingapp.service;

import com.shanwije.tradingapp.controller.request.RowPriceInfo;
import com.shanwije.tradingapp.dto.FormattedPriceInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PriceService {
    public Mono<FormattedPriceInfo> GetFormattedPriceInfo(RowPriceInfo rowPriceInfo);

    Flux<FormattedPriceInfo> findAll();
}
