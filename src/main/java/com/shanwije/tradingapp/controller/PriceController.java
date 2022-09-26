package com.shanwije.tradingapp.controller;

import com.shanwije.tradingapp.config.ResponseWrapper;
import com.shanwije.tradingapp.controller.request.RowPriceInfo;
import com.shanwije.tradingapp.service.PriceService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Log4j2
@RestController
@AllArgsConstructor
@RequestMapping(value = "/prices", produces = MediaType.APPLICATION_JSON_VALUE)
public class PriceController {

    PriceService priceService;
    ResponseWrapper<Object> responseWrapper;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<ResponseWrapper>> findAll() {
        return priceService.findAll()
                .collectList()
                .map(prices -> ResponseEntity.ok(responseWrapper.setData(prices)));
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = {"application/json"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<ResponseEntity<ResponseWrapper>> GetFormattedPrice(@Valid @RequestBody RowPriceInfo rowPriceInfo) {
        return priceService.GetFormattedPriceInfo(rowPriceInfo)
                .map(formattedPriceInfo -> ResponseEntity.ok(responseWrapper.setData(formattedPriceInfo)))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
