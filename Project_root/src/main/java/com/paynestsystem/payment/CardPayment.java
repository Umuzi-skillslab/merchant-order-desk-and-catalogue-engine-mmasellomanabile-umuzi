
package com.paynestsystem.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The user can makea payment via credit or debit card.
 
 */
public class CardPayment implements PaymentMethod {

    private final boolean simulateFailure;

    public CardPayment() {
        this(false);
    }

    public CardPayment(boolean simulateFailure) {
        this.simulateFailure = simulateFailure;
    }

    @Override
    public boolean processPayment(BigDecimal amount) {

        // Validate payment amount
        if (amount == null ||
                amount.compareTo(BigDecimal.ZERO) <= 0) {

            System.out.println("Card payment failed: Invalid amount.");
            return false;
        }

        // Simulate a declined card transaction
        if (simulateFailure) {
            System.out.println("Card payment declined.");
            return false;
        }

        System.out.println(
            "Processing card payment for R" +
            amount.setScale(2, RoundingMode.HALF_UP).toPlainString()
        );

        return true;
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}
