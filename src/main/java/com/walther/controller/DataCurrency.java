package com.walther.controller;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder; 
import com.walther.models.Code;
import com.walther.models.Currency;
import com.walther.models.CurrencyAdapter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse; 

public class DataCurrency {
    // API
    private static final String KEY = "";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + KEY + "/";

    private Code currencyData;

    // Getting the currency code
    private HttpResponse<String> getData(String url) {
        URI address = URI.create(url);
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();
        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to fetch data from URL: " + url, e);
        }
    }

    public <T> T find(String url, Class<T> type) {
        HttpResponse<String> response = getData(url);
        if (response.statusCode() != 200) {
            System.out.println("Error fetching data, status code: " + response.statusCode());
        }

        return setFromJson(response.body(), type);
    }

    private <T> T setFromJson(String json, Class<T> type) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Currency.class, new CurrencyAdapter())
                .create();
        return gson.fromJson(json, type);
    }

    public Code getCurrencyCodes() {
        currencyData = find(BASE_URL + "codes", Code.class);
//        System.out.println(currencyData); // Debugging

        return currencyData;
    }
}