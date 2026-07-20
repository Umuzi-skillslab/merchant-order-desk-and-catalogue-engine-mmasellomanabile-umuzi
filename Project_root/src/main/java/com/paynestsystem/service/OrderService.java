package com.paynestsystem.service;

import com.paynestsystem.domain.Order;

public class OrderService {

    public void printOrder(Order order) {
        order.printSummary();
    }
}