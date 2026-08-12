package com.paynestsystem.service;

import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.OrderItem;

public class OrderService {

    public String generateOrderSummary(Order order) {

        if (order == null) {
            throw new IllegalArgumentException(
                    "Order cannot be null"
            );
        }

        StringBuilder summary = new StringBuilder();

        summary.append("Order Summary:\n");
        summary.append("*********************************\n");
        summary.append("Order: #")
                .append(order.getId())
                .append("\n");
        summary.append("Customer: ")
                .append(order.getCustomer().getName())
                .append("\n");

        for (OrderItem item : order.getItems()) {
            summary.append(String.format(
                    "%s x%d = R%,.2f%n",
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.calculateTotal()
            ));
        }

        summary.append("*********************************\n");
        summary.append(String.format(
                "Grand Total: R%,.2f%n",
                order.calculateTotal()
        ));
        summary.append("*********************************\n");
        summary.append("Thank you for choosing us, ")
                .append(order.getCustomer().getName())
                .append("\n");
        summary.append("*********************************");

        return summary.toString();
    }
}