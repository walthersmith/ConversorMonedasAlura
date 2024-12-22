package com.walther.models;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public record Rates(String result,
                    String baseCode,
                    String targetCode,
                    BigDecimal conversionRate) {
}