package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    void testAddItemAndTotal() {

        Product product1 = new Product(
                1,
                "Keyboard",
                new BigDecimal("300.00")
        );

        Product product2 = new Product(
                2,
                "Mouse",
                new BigDecimal("200.00")
        );

        Customer customer = new Customer(
                1,
                "Maxine",
                "maxine@umuzi.com"
        );

        Order order = new Order(1, customer);

        order.addItem(product1, 5);
        order.addItem(product2, 10);

        assertEquals(
                new BigDecimal("3500.00"),
                order.calculateTotal(),
                "Total should be R3500.00"
        );
    }

    @Test
    void testEmptyOrderTotalIsZero() {

        Customer customer = new Customer(
                2,
                "Lucky",
                "lucky@umuzi.com"
        );

        Order order = new Order(2, customer);

        assertEquals(
                BigDecimal.ZERO,
                order.calculateTotal(),
                "Empty order should total R0.00"
        );
    }

    @Test
    void testAddItemWithZeroQuantityThrowsException() {

        Product product = new Product(
                3,
                "Monitor",
                new BigDecimal("1500.00")
        );

        Customer customer = new Customer(
                3,
                "Neo",
                "neo@umuzi.com"
        );

        Order order = new Order(3, customer);

        assertThrows(
                IllegalArgumentException.class,
                () -> order.addItem(product, 0)
        );
    }

    @Test
    void testAddItemWithNegativeQuantityThrowsException() {

        Product product = new Product(
                4,
                "Laptop",
                new BigDecimal("10000.00")
        );

        Customer customer = new Customer(
                4,
                "Trinity",
                "trinity@umuzi.com"
        );

        Order order = new Order(4, customer);

        assertThrows(
                IllegalArgumentException.class,
                () -> order.addItem(product, -1)
        );
    }

    @Test
    void testAddNullProductThrowsException() {

        Customer customer = new Customer(
                5,
                "Mpho",
                "mpho@umuzi.com"
        );

        Order order = new Order(5, customer);

        assertThrows(
                IllegalArgumentException.class,
                () -> order.addItem(null, 1)
        );
    }

    @Test
    void testNullCustomerThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Order(6, null)
        );
    }

    @Test
    void testItemsListIsProtected() {

        Product product = new Product(
                7,
                "Tablet",
                new BigDecimal("2000.00")
        );

        Customer customer = new Customer(
                7,
                "Kabelo",
                "kabelo@umuzi.com"
        );

        Order order = new Order(7, customer);

        order.addItem(product, 2);

        assertThrows(
                UnsupportedOperationException.class,
                () -> order.getItems().clear()
        );
    }
}