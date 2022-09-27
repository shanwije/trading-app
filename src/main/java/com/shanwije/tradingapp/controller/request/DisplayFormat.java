package com.shanwije.tradingapp.controller.request;

import java.math.BigDecimal;

public enum DisplayFormat {
    DECIMAL(1, "decimal"),
    PERCENTAGE(100, "percentage"),
    PER_MILE(1000, "per_mile"),
    BASIC_POINT(10000, "basic_point");

    private BigDecimal multiplier;
    private String name;

    DisplayFormat(int multiplier, String name) {
        this.multiplier = BigDecimal.valueOf(multiplier);
        this.name = name;
    }

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public String getName() {
        return name;
    }
}
