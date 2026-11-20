package com.paynestsystem.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Formats amounts for payment messages, so rounding and the currency
 * symbol are defined in one place.
 */
public final class MoneyFormat {

    private MoneyFormat() {
    }

    public static String rands(BigDecimal amount) {
        return "R" + amount.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}