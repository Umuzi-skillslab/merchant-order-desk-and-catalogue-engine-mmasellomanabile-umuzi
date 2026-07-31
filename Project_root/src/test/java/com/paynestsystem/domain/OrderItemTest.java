package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class OrderItemTest {

    @Test
    void testCalculateTotal() {
        Product prod = new Product(1, "Keyboard", 300);
        OrderItem item = new OrderItem(prod, 3);

        // Use compareTo to ignore scale differences (900 vs 900.0)
        assertEquals(0, item.calculateTotal().compareTo(BigDecimal.valueOf(900)),
            "3 Keyboards at R300 each should total R900.00");
    }

    @Test
    void testInvalidQuantityThrowsException() {
        Product prod = new Product(1, "Mouse", 150);

        assertThrows(IllegalArgumentException.class,
            () -> new OrderItem(prod, 0),
            "Quantity of 0 should throw exception");

        assertThrows(IllegalArgumentException.class,
            () -> new OrderItem(prod, -5),
            "Negative quantity should throw exception");
    }

    @Test
    void testNullProductThrowsException() {
        assertThrows(IllegalArgumentException.class,
            () -> new OrderItem(null, 2),
            "Null product should throw exception");
    }
}
