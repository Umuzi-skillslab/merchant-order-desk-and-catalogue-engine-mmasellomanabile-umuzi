package com.paynestsystem.app;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import com.paynestsystem.service.OrderService;

import java.math.BigDecimal;

public class PayNestApplication {

    public static void main(String[] args) {

        Product prod1 = new Product(
                1,
                "Headsets",
                new BigDecimal("1100.00")
        );

        Product prod2 = new Product(
                2,
                "Keyboard",
                new BigDecimal("200.00")
        );

        Customer customer = new Customer(
                1,
                "Maxine Ramokgopa",
                "maxineR@umuzi.org"
        );

        Order order = new Order(1, customer);

        order.addItem(prod1, 2);
        order.addItem(prod2, 4);

        OrderService service = new OrderService();

        System.out.println(
                service.generateOrderSummary(order)
        );
    }
}