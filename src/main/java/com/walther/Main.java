package com.walther;

import com.walther.controller.DataCurrency;
import com.walther.controller.Exchange;
import com.walther.models.Currency;
import com.walther.models.Code;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataCurrency dataCurrency = new DataCurrency();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Currency Converter ===");
            System.out.println("1. View available currencies");
            System.out.println("2. Convert currencies");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (option) {
                case 1:
                    // Show available currencies
                    Code codes = dataCurrency.getCurrencyCodes();
                    System.out.println("\nAvailable currencies:");
                    codes.supportedCodes().forEach(currency ->
                        System.out.println(currency.code() + " - " + currency.name()));
                    break;

                case 2:
                    // Convert currencies
                    Exchange exchange = new Exchange();
                    System.out.print("\nEnter source currency (example: USD): ");
                    String fromCurrency = scanner.nextLine().toUpperCase();

                    System.out.print("Enter target currency (example: EUR): ");
                    String toCurrency = scanner.nextLine().toUpperCase();

                    System.out.print("Enter amount to convert: ");
                    BigDecimal amount = BigDecimal.valueOf(scanner.nextDouble());

                    BigDecimal convertionRate = exchange.convertionRate(fromCurrency, toCurrency);
                    System.out.println("The conversion rate is: " + convertionRate);

                    BigDecimal exchangeValue = exchange.calculateExchangeRate(amount, convertionRate);
                    DecimalFormat df = new DecimalFormat("$###,###.##"); // or pattern "###,###.##$"

                    System.out.println("The exchange value is: " + df.format(exchangeValue)+" "+toCurrency);

                    System.out.println("Conversion functionality in development...");
                    break;

                case 3:
                    running = false;
                    System.out.println("Thank you for using the currency converter!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}