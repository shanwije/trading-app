package com.shanwije.tradingapp.pricer;

import java.math.BigDecimal;

public class SetBigFigure implements Pricer<BigDecimal, Integer> {

    @Override
    public int set(BigDecimal price) {
        return 0;
    }
}
