package com.shanwije.tradingapp.usecase.converter;

import com.shanwije.tradingapp.dto.FormattedPriceInfo;
import com.shanwije.tradingapp.controller.request.RowPriceInfo;

public interface Converter<T, R> {
    static FormattedPriceInfo convert(RowPriceInfo rowPriceInfo) {
        return null;
    }

}
