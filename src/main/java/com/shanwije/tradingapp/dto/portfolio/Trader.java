package com.shanwije.tradingapp.dto.portfolio;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Trader {
    private ArrayList<Portfolio> portfolios = new ArrayList<>();
}
