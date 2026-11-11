package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    void testAddItemAndTotal() {
        Product prod1 = new Product(1, "Keyboard", BigDecimal.valueOf(300));
        Product prod2 = new Product(2, "Mouse", BigDecimal.valueOf(200));

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
    void emptyOrderTotalIsZero() {
    Order order = new Order(1, new Customer(1, "Maxine", "m@umuzi.org"));
    assertEquals(0, order.calculateTotal().compareTo(BigDecimal.ZERO));
}

    @Test
    void grandTotalEqualsSumOfLineTotals() {
        Order order = new Order(1, new Customer(1, "Maxine", "m@umuzi.org"));
        order.addItem(new Product(1, "Cable", new BigDecimal("10.005")), 3);
        order.addItem(new Product(2, "Plug", new BigDecimal("10.005")), 1);

        BigDecimal sumOfLines = order.getItems().stream()
                .map(OrderItem::calculateTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        assertEquals(0, order.calculateTotal().compareTo(sumOfLines));
    }
}
