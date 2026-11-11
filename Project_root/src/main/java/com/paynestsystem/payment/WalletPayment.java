
package com.paynestsystem.payment;

import java.math.BigDecimal;


public class WalletPayment implements PaymentMethod {

    @Override
    public boolean processPayment(BigDecimal amount) {
        System.out.println("Processing wallet payment for R" + String.format("%.2f", amount));
        return true; // Simulated payment for the capstone demo.
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}