package com.shanwije.tradingapp.usecase.converter;

import com.shanwije.tradingapp.controller.request.RowPriceInfo;
import com.shanwije.tradingapp.dto.FormattedPriceInfo;

public interface Converter<T, R> {
    static FormattedPriceInfo convert(RowPriceInfo rowPriceInfo) {
        return null;
    }

}
