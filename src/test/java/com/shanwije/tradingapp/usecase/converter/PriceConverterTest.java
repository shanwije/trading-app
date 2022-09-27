package com.shanwije.tradingapp.usecase.converter;

import com.shanwije.tradingapp.controller.request.RowPriceInfo;
import com.shanwije.tradingapp.dto.FormattedPrice;
import com.shanwije.tradingapp.dto.FormattedPriceInfo;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceConverterTest {

    @Test
    void convert() {
        String currency = "USD";

        String percentage = "percentage";
        String decimal = "decimal";
        String basicPoint = "basic_point";

        RowPriceInfo rp1 = new RowPriceInfo(currency, BigDecimal.valueOf(47.92), BigDecimal.valueOf(34.24), decimal, 4, 2, 3);
        FormattedPrice fp1a = new FormattedPrice("4", "7.9", "2");
        FormattedPrice fp1b = new FormattedPrice("3", "4.2", "4");
        FormattedPriceInfo fp1 = new FormattedPriceInfo(currency, fp1a, fp1b);
        assertThat(fp1).usingRecursiveComparison().isEqualTo(PriceConverter.convert(rp1));

        RowPriceInfo rp2 = new RowPriceInfo(currency, BigDecimal.valueOf(0.1523), BigDecimal.valueOf(0.1523), percentage, 4, 1, 2);
        FormattedPrice fp2a = new FormattedPrice("15.2", "3", "");
        FormattedPrice fp2b = new FormattedPrice("15.2", "3", "");
        FormattedPriceInfo fp2 = new FormattedPriceInfo(currency, fp2a, fp2b);
        assertThat(fp2).usingRecursiveComparison().isEqualTo(PriceConverter.convert(rp2));

        RowPriceInfo rp3 = new RowPriceInfo(currency, BigDecimal.valueOf(0.16754), BigDecimal.valueOf(0.16754), percentage, 4, 1, 2);
        FormattedPrice fp3a = new FormattedPrice("16.7", "5", "4");
        FormattedPrice fp3b = new FormattedPrice("16.7", "5", "4");
        FormattedPriceInfo fp3 = new FormattedPriceInfo(currency, fp3a, fp3b);
        assertThat(fp3).usingRecursiveComparison().isEqualTo(PriceConverter.convert(rp3));

        RowPriceInfo rp4 = new RowPriceInfo(currency, BigDecimal.valueOf(0.0018), BigDecimal.valueOf(0.0018), basicPoint, 2, 3, 1);
        FormattedPrice fp4a = new FormattedPrice("", "18.0", "");
        FormattedPrice fp4b = new FormattedPrice("", "18.0", "");
        FormattedPriceInfo fp4 = new FormattedPriceInfo(currency, fp4a, fp4b);
        assertThat(fp4).usingRecursiveComparison().isEqualTo(PriceConverter.convert(rp4));
    }

    @Test
    void removeTrailingZeroes() {
        assertEquals("2", PriceConverter.removeTrailingZeroes("200"));
        assertEquals("2.12", PriceConverter.removeTrailingZeroes("2.1200"));
        assertEquals("2.12001", PriceConverter.removeTrailingZeroes("2.12001"));
        assertEquals("002", PriceConverter.removeTrailingZeroes("002"));
        assertEquals("1002", PriceConverter.removeTrailingZeroes("1002"));
        assertEquals("123.", PriceConverter.removeTrailingZeroes("123."));
    }

    @Test
    void isInBetween() {
        assertEquals(true, PriceConverter.isInBetween(2, 5, 1));
        assertEquals(false, PriceConverter.isInBetween(2, 5, 4));
        assertEquals(false, PriceConverter.isInBetween(5, 3, 1));
        assertEquals(true, PriceConverter.isInBetween(2, 2, 2));
        assertEquals(true, PriceConverter.isInBetween(2, 2, 1));
        assertEquals(true, PriceConverter.isInBetween(2, 5, 2));
    }

    @Test
    void getFormattedPrice() {
    }
}
