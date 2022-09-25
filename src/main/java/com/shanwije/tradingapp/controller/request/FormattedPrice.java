package com.shanwije.tradingapp.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormattedPrice {
    private double bigFigure;
    private double dealingPrice;
    private double fractionalPips;
}
