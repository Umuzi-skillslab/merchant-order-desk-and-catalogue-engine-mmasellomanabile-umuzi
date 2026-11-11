package com.paynestsystem.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void nullOrNegativePriceIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product(1, "Mouse", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Product(1, "Mouse", new BigDecimal("-1")));
    }

    @Test
    void blankNameIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Product(1, "  ", BigDecimal.TEN));
    }

    @Test
    void priceIsRoundedToTwoDecimals() {
        Product p = new Product(1, "Cable", new BigDecimal("10.005"));
        assertEquals(new BigDecimal("10.01"), p.getPrice());
    }

    @Test
    void customerWithBlankDetailsIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> new Customer(1, "", "a@b.com"));
        assertThrows(IllegalArgumentException.class,
                () -> new Customer(1, "Sam", " "));
    }
}