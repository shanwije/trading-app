package com.shanwije.tradingapp.service;

import com.shanwije.tradingapp.controller.request.FormattedPriceInfo;
import com.shanwije.tradingapp.controller.request.RowPriceInfo;
import reactor.core.publisher.Mono;

public interface PriceService {
    public Mono<FormattedPriceInfo> GetFormattedPriceInfo(RowPriceInfo rowPriceInfo);
}
