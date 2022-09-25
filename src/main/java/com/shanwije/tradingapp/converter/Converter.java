package com.shanwije.tradingapp.converter;

import com.shanwije.tradingapp.controller.request.FormattedPriceInfo;
import com.shanwije.tradingapp.controller.request.RowPriceInfo;

public interface Converter<T, R> {
    static FormattedPriceInfo convert(RowPriceInfo rowPriceInfo) {
        return null;
    }

}
