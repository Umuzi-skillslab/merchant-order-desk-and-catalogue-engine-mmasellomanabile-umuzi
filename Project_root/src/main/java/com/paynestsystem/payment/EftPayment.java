// EftPayment.java
package com.paynestsystem.payment;

import java.math.BigDecimal;


public class EftPayment implements PaymentMethod {

    @Override
    public boolean processPayment(BigDecimal amount) {
        System.out.println("Processing EFT bank transfer for R" + String.format("%.2f", amount));
        return true; // Simulated payment for the capstone demo.
    }

    @Override
    public String getPaymentType() {
        return "EFT";
    }
}