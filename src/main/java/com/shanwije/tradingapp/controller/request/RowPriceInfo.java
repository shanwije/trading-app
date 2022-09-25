package com.shanwije.tradingapp.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RowPriceInfo {
    @NotBlank(message = "Row price cannot be empty")
    @Positive
    private double rowBidPrice;

    @NotBlank(message = "Row price cannot be empty")
    @Positive
    private double rowOfferPrice;

    @NotBlank(message = "Display format cannot be empty")
    private String displayFormat;

    @NotBlank(message = "Scale cannot be empty")
    @Positive
    @Pattern(regexp = "(?<!\\d)\\d(?!\\d)", message = "Invalid scale")
    private int scale;

    @NotBlank(message = "DPL cannot be empty")
    @Positive
    private int dpl;

    @NotBlank(message = "FPL cannot be empty")
    @Positive
    private int fpl;
}
