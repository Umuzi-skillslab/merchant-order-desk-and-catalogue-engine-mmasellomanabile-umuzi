package com.paynestsystem.service;

import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.OrderItem;

public class OrderService {

    public void printOrder(Order order) {
        System.out.println("Order Summary:");
        System.out.println("*********************************");
        System.out.println("Customer: " + order.getCustomer().getName());

        for (OrderItem item : order.getItems()) {
            System.out.printf("%s x%d = R%.2f%n",
                item.getProduct().getName(),
                item.getQuantity(),
                item.calculateTotal());
        }

        System.out.println("****************************************");
        System.out.printf("Your total is: R%.2f%n", order.calculateTotal());
          System.out.println("****************************************");
        System.out.println("Thank you for choosing us " + order.getCustomer().getName());
        System.out.println("****************************************");
    }
}
