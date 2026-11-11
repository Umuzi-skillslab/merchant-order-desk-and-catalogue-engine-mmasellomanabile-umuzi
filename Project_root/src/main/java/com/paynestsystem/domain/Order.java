package com.paynestsystem.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collections;
import com.paynestsystem.payment.PaymentMethod;
import com.paynestsystem.payment.PaymentProcessor;

public class Order {
<<<<<<< HEAD
    private final int id;                 
    private final Customer customer;      
    private final List<OrderItem> items;  
=======
>>>>>>> 3b5781837c91bf811c4d126f2add762352413bef

    private final int id;
    private final Customer customer;
    private final List<OrderItem> items;

    public Order(int id, Customer customer) {

        if (customer == null) {
            throw new IllegalArgumentException(
                    "Customer cannot be null"
            );
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
<<<<<<< HEAD
        return Collections.unmodifiableList(items); 
=======
        return Collections.unmodifiableList(items);
>>>>>>> 3b5781837c91bf811c4d126f2add762352413bef
    }

    public void addItem(Product product, int quantity) {

        if (product == null) {
            throw new IllegalArgumentException(
                    "Product cannot be null"
            );
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than 0"
            );
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
<<<<<<< HEAD

    public void checkout(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            throw new IllegalArgumentException("Payment method cannot be null");
        }
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot check out an empty order");
        }

        BigDecimal total = calculateTotal();
        PaymentProcessor processor = new PaymentProcessor();
        boolean success = processor.processPayment(paymentMethod, total);

        if (success) {
            System.out.println("Order completed successfully.");
        } else {
            System.out.println("Order checkout failed.");
        }
    }

}
=======
}
>>>>>>> 3b5781837c91bf811c4d126f2add762352413bef
