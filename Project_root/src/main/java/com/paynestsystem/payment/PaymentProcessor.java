// PaymentProcessor.java
package com.paynestsystem.payment;

import java.math.BigDecimal;
import java.util.Collections;

public class PaymentProcessor {

    public boolean processPayment(PaymentMethod method, BigDecimal amount) {
        if (method == null) {
            throw new IllegalArgumentException("Payment method cannot be null");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }

        boolean success = method.processPayment(amount);

        if (success) {
            System.out.println("Payment successful via " + method.getPaymentType());
            System.out.println("Amount: R" + String.format("%.2f", amount));
        } else {
            System.out.println("Payment failed via " + method.getPaymentType());
        }

        return success;
    }
}