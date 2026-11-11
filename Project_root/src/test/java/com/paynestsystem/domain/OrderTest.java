package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class OrderTest {

    @Test
    void testAddItemAndTotal() {
        Product prod1 = new Product(1, "Keyboard", BigDecimal.valueOf(300));
        Product prod2 = new Product(2, "Mouse", BigDecimal.valueOf(200));

        Customer customer = new Customer(1, "Maxine", "maxine@umuzi.com");
        Order order = new Order(1, customer);  

        order.addItem(prod1, 5);  
        order.addItem(prod2, 10);

        assertEquals(0, order.calculateTotal().compareTo(BigDecimal.valueOf(3500)),
            "Total should be R3500.00");
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
