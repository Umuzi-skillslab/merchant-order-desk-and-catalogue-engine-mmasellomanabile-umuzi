package com.paynestsystem.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class MoneyFormatTest {

    @Test
    void formatsWholeAmountToTwoDecimals() {
        assertEquals("R3200.00", MoneyFormat.rands(new BigDecimal("3200")));
    }

    @Test
    void roundsHalfUpToTwoDecimals() {
        assertEquals("R10.01", MoneyFormat.rands(new BigDecimal("10.005")));
    }
}