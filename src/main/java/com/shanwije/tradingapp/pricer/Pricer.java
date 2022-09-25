package com.shanwije.tradingapp.pricer;

import java.math.BigDecimal;

public interface Pricer <T, Integer> {
    int set(T obj);
}
