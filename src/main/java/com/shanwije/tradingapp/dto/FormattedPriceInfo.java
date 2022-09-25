package com.shanwije.tradingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("price-info")
public class FormattedPriceInfo {
    @Id
    private String currency;
    private FormattedPrice formattedBidPrice;
    private FormattedPrice formattedOfferPrice;
}
