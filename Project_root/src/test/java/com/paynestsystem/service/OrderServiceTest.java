package com.paynestsystem.service;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void testGenerateOrderSummaryContainsExpectedInformation() {

        Product product1 = new Product(
                1,
                "Headsets",
                new BigDecimal("1100.00")
        );

        Product product2 = new Product(
                2,
                "Keyboard",
                new BigDecimal("200.00")
        );

        Customer customer = new Customer(
                1,
                "Maxine Ramokgopa",
                "maxine@umuzi.org"
        );

        Order order = new Order(1, customer);

        order.addItem(product1, 2);
        order.addItem(product2, 4);

        OrderService service = new OrderService();

        String summary = service.generateOrderSummary(order);

        assertTrue(summary.contains("Order: #1"));
        assertTrue(summary.contains("Maxine Ramokgopa"));
        assertTrue(summary.contains("Headsets"));
        assertTrue(summary.contains("Keyboard"));
        assertTrue(summary.contains("x2"));
        assertTrue(summary.contains("x4"));
        assertTrue(summary.contains("R2,200.00"));
        assertTrue(summary.contains("R800.00"));
        assertTrue(summary.contains("Grand Total: R3,000.00"));
    }

    @Test
    void testNullOrderThrowsException() {

        OrderService service = new OrderService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.generateOrderSummary(null)
        );
    }
}