package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    void testValidProduct() {

        Product product = new Product(
                1,
                "Keyboard",
                new BigDecimal("300.00")
        );

        assertEquals(1, product.getId());
        assertEquals("Keyboard", product.getName());
        assertEquals(
                new BigDecimal("300.00"),
                product.getPrice()
        );
    }

    @Test
    void testBlankNameThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Product(
                        1,
                        " ",
                        new BigDecimal("300.00")
                )
        );
    }

    @Test
    void testNullPriceThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Product(
                        1,
                        "Keyboard",
                        null
                )
        );
    }

    @Test
    void testNegativePriceThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Product(
                        1,
                        "Keyboard",
                        new BigDecimal("-1.00")
                )
        );
    }
}