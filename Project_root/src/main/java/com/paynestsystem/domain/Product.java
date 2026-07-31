package com.paynestsystem.domain;

import java.math.BigDecimal;

    public class Product {
    private final int id;
    private final String name;
    private final BigDecimal price;

    public Product(int id, String name, double price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.price = BigDecimal.valueOf(price);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (R" + price + ")";
    }
}
