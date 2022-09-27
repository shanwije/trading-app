package com.shanwije.tradingapp.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RowPriceInfo {

    @NotBlank(message = "Currency cannot be empty")
    @Pattern(regexp = "[A-Z]{3}(?<![A-Z]{4})(?![A-Z])", message = "Invalid currency symbol")
    private String currency;

    @NotNull
    @Digits(integer = 5, fraction = 5)
    private BigDecimal rowBidPrice;

    @NotNull
    private BigDecimal rowOfferPrice;

    @NotBlank(message = "Display format cannot be empty")
    private String displayFormat;

    @Positive
    @Digits(integer = 5, fraction = 0)
    private int scale;

    @Positive
    @Digits(integer = 5, fraction = 0)
    private int dpl;

    @Positive
    @Digits(integer = 5, fraction = 0)
    private int fpl;
}
