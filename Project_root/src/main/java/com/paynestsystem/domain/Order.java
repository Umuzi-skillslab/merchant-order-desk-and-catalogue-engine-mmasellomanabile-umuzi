package com.paynestsystem.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;                 
    private Customer customer;      
    private List<OrderItem> items;  

    
    public Order(int id, Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    
    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderItem> getItems() {
        return items; 
    }

    
    public void addItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        items.add(new OrderItem(product, quantity));
    }


    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderItem item : items) {
            total = total.add(item.calculateTotal());
        }
        return total;
    }
}
