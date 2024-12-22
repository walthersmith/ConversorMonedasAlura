package com.walther.controller;

import com.walther.models.Rates;

import java.math.BigDecimal;

public class Exchange {
    private static final String KEY = "";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + KEY + "/";
    private String from;
    private String to;

    public Exchange() {
    }
    public Exchange(String from, String to, double amount, double result) {
        this.from = from;
        this.to = to;

    }

    public BigDecimal convertionRate(String baseCode, String targetCode) {
         DataCurrency dataCurrency = new DataCurrency();
         Rates rates =   dataCurrency.find(BASE_URL+"/pair/" + baseCode + "/" + targetCode, Rates.class);
         return rates.conversionRate();
    }



    //calculate the exchange rate
    public BigDecimal calculateExchangeRate( BigDecimal amount, BigDecimal result) {
        return amount.multiply(result);
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }


    @Override
    public String toString() {
        return "Exchange{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }


}
