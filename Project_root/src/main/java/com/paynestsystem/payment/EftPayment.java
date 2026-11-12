
package com.paynestsystem.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * User makes a payment via Electronic Funds Transfer (EFT).
 
 */
public class EftPayment implements PaymentMethod {

    private final boolean simulateFailure;

    public EftPayment() {
        this(false);
    }

    public EftPayment(boolean simulateFailure) {
        this.simulateFailure = simulateFailure;
    }

    @Override
    public boolean processPayment(BigDecimal amount) {

        // Validate payment amount
        if (amount == null ||
                amount.compareTo(BigDecimal.ZERO) <= 0) {

            System.out.println("EFT payment failed: Invalid amount.");
            return false;
        }

        // Simulate an unsuccessful bank transfer
        if (simulateFailure) {
            System.out.println("EFT bank transfer failed.");
            return false;
        }

        System.out.println(
            "Processing EFT bank transfer for R" +
            amount.setScale(2, RoundingMode.HALF_UP).toPlainString()
        );

        return true;
    }

    @Override
    public String getPaymentType() {
        return "EFT";
    }
}
