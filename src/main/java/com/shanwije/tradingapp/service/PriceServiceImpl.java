package com.shanwije.tradingapp.service;

import com.shanwije.tradingapp.controller.request.FormattedPriceInfo;
import com.shanwije.tradingapp.controller.request.RowPriceInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {
    /**
     * @param rowPriceInfo
     * @return
     */
    @Override
    public Mono<FormattedPriceInfo> GetFormattedPriceInfo(RowPriceInfo rowPriceInfo) {
        return Mono.just(rowPriceInfo).map(r -> new FormattedPriceInfo(r));
    }
}
