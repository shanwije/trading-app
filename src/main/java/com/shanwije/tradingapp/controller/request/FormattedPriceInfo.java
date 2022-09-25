package com.shanwije.tradingapp.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormattedPriceInfo {
    private FormattedPrice formattedBidPrice;
    private FormattedPrice formattedOfferPrice;
}
