package com.shanwije.tradingapp.service;

import com.shanwije.tradingapp.controller.request.RowPriceInfo;
import com.shanwije.tradingapp.dto.FormattedPriceInfo;
import com.shanwije.tradingapp.repository.PriceRepository;
import com.shanwije.tradingapp.usecase.converter.PriceConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {

    PriceRepository repository;


    @Override
    public Mono<FormattedPriceInfo> GetFormattedPriceInfo(RowPriceInfo rowPriceInfo) {
        return repository.save(PriceConverter.convert(rowPriceInfo))
                .cast(FormattedPriceInfo.class);
    }

    @Override
    public Flux<FormattedPriceInfo> findAll() {
        return repository.findAll().flatMap(prices ->
                Mono.just(new FormattedPriceInfo(prices)));
    }
}
