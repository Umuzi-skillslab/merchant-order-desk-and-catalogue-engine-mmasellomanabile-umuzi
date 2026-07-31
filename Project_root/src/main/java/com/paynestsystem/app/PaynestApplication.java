package com.paynestsystem.app;

import com.paynestsystem.domain.*;
import com.paynestsystem.service.OrderService;

public class PaynestApplication {
    public static void main(String[] args) {
        
        Product prod1 = new Product(1, "Headsets", 1000);
        Product prod2 = new Product(2, "Keyboard", 300);

        Customer customer = new Customer(1, "Maxine Ramokgopa", "maxineR@umuzi.org");

        Order order = new Order(1, customer);

        order.addItem(prod1, 2);
        order.addItem(prod2, 4);

        OrderService service = new OrderService();
        service.printOrder(order);
    }
}
