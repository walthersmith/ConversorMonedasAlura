# Currency Exchange API

This project is a Java-based application that interacts with the ExchangeRate-API to fetch currency codes and conversion rates. It uses Maven for dependency management and Gson for JSON deserialization.

## Project Structure

- `src/main/java/com/walther/models/`
    - `Code.java`: Represents the API response structure.
    - `Currency.java`: Represents a currency code and name.
    - `Rates.java`: Represents the exchange rates.
- `src/main/java/com/walther/controller/`
    - `DataCurrency.java`: Handles fetching and deserializing data from the API.
    - `Exchange.java`: Handles currency conversion logic.

## Dependencies

- Java 11 or higher
- Maven
- Gson

## Setup

1. Clone the repository:
   ```sh
   git clone https://github.com/walthersmith/currency-exchange-api.git
   cd currency-exchange-api
   ```

2. Add your API key:
    - Open `DataCurrency.java` and `Exchange.java`.
    - Replace the `KEY` variable with your ExchangeRate-API key.

3. Build the project:
   ```sh
   mvn clean install
   ```

## Usage

### Fetch Currency Codes

To fetch and print the supported currency codes:

```java
DataCurrency dataCurrency = new DataCurrency();
Code currencyCodes = dataCurrency.getCurrencyCodes();
currencyCodes.getSupportedCodes().forEach(code -> 
    System.out.println(code.getCode() + ": " + code.getName()));
```

### Convert Currency

To convert an amount from one currency to another:

```java
Exchange exchange = new Exchange();
BigDecimal rate = exchange.convertionRate("USD", "EUR");
BigDecimal amount = new BigDecimal("100");
BigDecimal result = exchange.calculateExchangeRate(amount, rate);
System.out.println("Converted amount: " + result);
```

## Acknowledgements

- [ExchangeRate-API](https://www.exchangerate-api.com/) for providing the currency exchange data.
- ALURA LATAM for the Java course.
- ORACLE ONE EDUCATION for the Java course.