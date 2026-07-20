
package com.paynestsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.paynestsystem.domain.Product;
import com.paynestsystem.domain.OrderItem;

public class OrderItemTest {

    @Test
    void testcalculateTotal() {
        Product prod = new Product(1, "Keyboard", 300);
        OrderItem item = new OrderItem(prod, 3);

        assertEquals(900.0, item.calculateTotal(), "3 Keyboards at R300 each should total R900");
    }
}
