package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class OrderTest {

    @Test
    void testAddItemAndTotal() {
        Product prod1 = new Product(1, "Keyboard", 300);
        Product prod2 = new Product(2, "Mouse", 200);

        Customer customer = new Customer(1, "Maxine", "maxine@umuzi.com");
        Order order = new Order(1, customer);  

        order.addItem(prod1, 5);  
        order.addItem(prod2, 10);

        assertEquals(0, order.calculateTotal().compareTo(BigDecimal.valueOf(3500)),
            "Total should be R3500.00");
    }
}
