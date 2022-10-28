package com.shanwije.tradingapp.dto.portfolio;

import lombok.Data;

@Data
public class Order {
    private Integer notional;
    private int flexiPlus;
    private int flexiMinus;
    private String date;

    private Order(){}


    public static Order createOrder(Integer notional, int flexiPlus, int flexiMinus, String date) {
        Order order = new Order();
        order.setNotional(notional);
        order.setFlexiPlus(flexiPlus);
        order.setFlexiMinus(flexiMinus);
        order.setDate(date);
        //validations
        if(!order.validate(order)) {
            throw new IllegalArgumentException("Invalid arguments were given");
        }

        return order;
    }


    public static boolean validate(Order order) {
        int fPlus = order.getFlexiPlus();
        int fMinus = order.getFlexiMinus();
        if(order.getNotional() == null) {
            // throw custom error here
            return false;
        }
        if(fPlus == 0 && fMinus == 0) {
            // throw custom error here
            return false;
        }
        if( !(fPlus < 16 && fPlus > -16) || !(fMinus < 16 && fMinus > -16)) {
            // throw custom error here
            return false;
        }

        return true;
    }
}
