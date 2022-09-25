package com.shanwije.tradingapp.converter;


import com.shanwije.tradingapp.controller.request.DisplayFormat;
import com.shanwije.tradingapp.controller.request.FormattedPrice;
import com.shanwije.tradingapp.controller.request.FormattedPriceInfo;
import com.shanwije.tradingapp.controller.request.RowPriceInfo;

import java.math.BigDecimal;

public class PriceConverter {

    public static FormattedPriceInfo convert(RowPriceInfo rowPriceInfo) {

        BigDecimal bp = BigDecimal.valueOf(rowPriceInfo.getRowBidPrice());
        String displayFormat = rowPriceInfo.getDisplayFormat();

        for (DisplayFormat format : DisplayFormat.values()) {
            if(format.getName().equals(displayFormat)){
                bp = bp.multiply(format.getMultiplier());
            }
        }

        bp = bp.setScale(rowPriceInfo.getScale());

        //to split into 3 parts, i find https://math.stackexchange.com/questions/2815438/finding-the-last-two-digits-of-the-given-number
        // is the most compelling way. but for easiness go with string substring method.

        String bpStr = bp.toString();
//        bpStr =  bpStr.replace(".","");

        int fplStartIndex = bpStr.length() - rowPriceInfo.getFpl();
        int dplStartIndex = bpStr.length() - (rowPriceInfo.getDpl() + rowPriceInfo.getFpl());


        int dotIndex = bpStr.indexOf(".");

        if(dotIndex != -1) {
            if (isInBetween(dotIndex, bpStr.length(),fplStartIndex)) {
                fplStartIndex -= 1;
            } else if (isInBetween(dotIndex, fplStartIndex, dplStartIndex)) {
                dplStartIndex -= 1;
            }
        }

        String fractionalPipStr = bpStr.substring(fplStartIndex);

        String dealingPriceStr = bpStr.substring(dplStartIndex, fplStartIndex);

        String bigFigureStr = bpStr.substring(0, dplStartIndex);



        FormattedPrice fp = new FormattedPrice(bigFigure, dealingPrice, fractionalPip);


        FormattedPriceInfo fpi = new FormattedPriceInfo(fp, fp);
        return fpi;

    }
    public static boolean isInBetween(int val,int ceiling,int floor) {
        return ceiling >= val && val >= floor;
    }
}
