package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.paynestsystem.domain.Product;
import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.OrderItem;

public class OrderTest {

    @Test
    void testAddItemAndTotal() {
        Product prod1 = new Product(1, "Headsets", 1000);
        Product prod2 = new Product(2, "Keyboard", 300);
        Customer customer = new Customer(1, "Maxine Ramokgopa", "maxineR@umuzi.org");
        Order order = new Order(1, customer);

        order.addItem(prod1, 2);  // R2000
        order.addItem(prod2, 4);  // R1200

        assertEquals(3200.0, order.calculateTotal(), "Total should be R3200.0");
    }

    @Test
    void testAddInvalidQuantity() {
        Product prod = new Product(1, "Mouse", 150);
        Customer customer = new Customer(1, "Lucky Fish", "lucky.fish@gmail.com");
        Order order = new Order(2, customer);

        order.addItem(prod, 0); // invalid
        assertEquals(0.0, order.calculateTotal(), "Total should remain 0 when quantity is invalid");
    }
}
