package com.shanwije.tradingapp.controller.request;

import lombok.Data;

@Data
public class FormattedPriceInfo {
    private int price;

    public FormattedPriceInfo(RowPriceInfo rowPriceInfo) {
        this.price = rowPriceInfo.getPrice() * 2;
    }
}
