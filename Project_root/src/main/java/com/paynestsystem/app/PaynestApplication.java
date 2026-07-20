package com.paynestsystem.app;

import com.paynestsystem.domain.*;
import com.paynestsystem.service.OrderService;

public class PaynestApplication {
    public static void main(String[] args) {
        // Products sample:
        Product prod1 = new Product(1, "Headsets", 1000);
        Product prod2 = new Product(2, "Keyboard", 300);

        // Customer sample:
        Customer customer = new Customer(1, "Maxine Ramokgopa", "maxineR@umuzi.org");

        // Order sample:
        Order order = new Order(1, customer);

        // Add items:
        order.addItem(prod1, 2);
        order.addItem(prod2, 4);

        // Summary via service:
        OrderService service = new OrderService();
        service.printOrder(order);
    }
}
