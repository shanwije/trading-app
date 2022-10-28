package com.shanwije.tradingapp.dto.portfolio;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Portfolio {
    private ArrayList<Order> orders;

    public void submitOrder() {
        if(validateOrders(orders)) {
            System.out.println("there's a validation error");
        };
        // continue with the submission
    }


    public boolean validateOrders(ArrayList<Order> orders) {
        for(Order order : orders) {
            if(!Order.validate(order)) {
                //  throw new IllegalArgumentException("error something...");
                return false;
            }
        }
        return true;
    }
}
