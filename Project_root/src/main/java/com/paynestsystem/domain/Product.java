package com.paynestsystem.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Product {

    private final int id;
    private final String name;
    private final BigDecimal price;

    public Product(int id, String name, BigDecimal price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.id = id;
        this.name = name;
        // Rounding policy: prices are stored to 2 decimal places, HALF_UP.
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (R" + price + ")";
    }
}