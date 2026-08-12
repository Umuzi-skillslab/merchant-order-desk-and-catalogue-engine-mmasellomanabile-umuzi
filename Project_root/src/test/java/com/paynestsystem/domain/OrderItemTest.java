package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class OrderItemTest {

    @Test
    void testCalculateTotal() {

        Product product = new Product(
                1,
                "Keyboard",
                new BigDecimal("300.00")
        );

        OrderItem item = new OrderItem(product, 3);

        assertEquals(
                new BigDecimal("900.00"),
                item.calculateTotal(),
                "3 Keyboards at R300 each should total R900.00"
        );
    }

    @Test
    void testDecimalPriceCalculation() {

        Product product = new Product(
                2,
                "USB Cable",
                new BigDecimal("99.99")
        );

        OrderItem item = new OrderItem(product, 3);

        assertEquals(
                new BigDecimal("299.97"),
                item.calculateTotal(),
                "3 USB cables at R99.99 should total R299.97"
        );
    }

    @Test
    void testInvalidQuantityThrowsException() {

        Product product = new Product(
                3,
                "Mouse",
                new BigDecimal("150.00")
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new OrderItem(product, 0)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new OrderItem(product, -5)
        );
    }

    @Test
    void testNullProductThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new OrderItem(null, 2)
        );
    }
}