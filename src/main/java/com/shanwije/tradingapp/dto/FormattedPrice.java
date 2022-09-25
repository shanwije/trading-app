package com.shanwije.tradingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormattedPrice {
    private String bigFigure;
    private String dealingPrice;
    private String fractionalPips;
}
