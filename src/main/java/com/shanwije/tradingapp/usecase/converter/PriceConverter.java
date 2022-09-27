package com.shanwije.tradingapp.usecase.converter;


import com.shanwije.tradingapp.controller.request.DisplayFormat;
import com.shanwije.tradingapp.dto.FormattedPrice;
import com.shanwije.tradingapp.dto.FormattedPriceInfo;
import com.shanwije.tradingapp.controller.request.RowPriceInfo;

import java.math.BigDecimal;

public class PriceConverter {
    private PriceConverter() {
    }

    public static FormattedPriceInfo convert(RowPriceInfo rowPriceInfo) {
        FormattedPrice bidPrice = getFormattedPrice(rowPriceInfo, rowPriceInfo.getRowBidPrice());
        FormattedPrice offerPrice = getFormattedPrice(rowPriceInfo, rowPriceInfo.getRowOfferPrice());
        return new FormattedPriceInfo(rowPriceInfo.getCurrency(), bidPrice, offerPrice);
    }

    protected static FormattedPrice getFormattedPrice(RowPriceInfo rowPriceInfo, BigDecimal rowPrice) {

        //set multiplier using display format value
        String displayFormat = rowPriceInfo.getDisplayFormat();

        for (DisplayFormat format : DisplayFormat.values()) {
            if(format.getName().equals(displayFormat)){
                rowPrice = rowPrice.multiply(format.getMultiplier());
            }
        }

        //add extra 0 to the end using scale value
        rowPrice = rowPrice.setScale(rowPriceInfo.getScale());

        //to split into 3 parts, i find https://math.stackexchange.com/questions/2815438/finding-the-last-two-digits-of-the-given-number
        // is the most compelling way. but for easiness go with string substring method.
        String bpStr = rowPrice.toString();

        int fplStartIndex = bpStr.length() - rowPriceInfo.getFpl();
        int dplStartIndex = bpStr.length() - (rowPriceInfo.getDpl() + rowPriceInfo.getFpl());


        //tracking the "." location, so it won't affect the splitting of string
        int dotIndex = bpStr.indexOf(".");
        if(dotIndex != -1) {
            if (isInBetween(dotIndex, bpStr.length(),fplStartIndex)) {
                fplStartIndex -= 1;
            } else if (isInBetween(dotIndex, fplStartIndex, dplStartIndex)) {
                dplStartIndex -= 1;
            }
        }

        String fractionalPipStr = bpStr.substring(fplStartIndex);
        fractionalPipStr = removeTrailingZeroes(fractionalPipStr);
        String dealingPriceStr = bpStr.substring(dplStartIndex, fplStartIndex);
        String bigFigureStr = bpStr.substring(0, dplStartIndex);

        return new FormattedPrice(bigFigureStr, dealingPriceStr, fractionalPipStr);
    }

    public static String removeTrailingZeroes(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static boolean isInBetween(int val,int ceiling,int floor) {
        return ceiling >= val && val >= floor;
    }
}
