
package com.paynestsystem.payment;

import java.math.BigDecimal;
import com.paynestsystem.util.MoneyFormat;

/**
 * The user can make a payment via credit or debit card.
 
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

        // Simulate a declined card transaction
        if (simulateFailure) {
           System.out.println("Card payment declined.");
            return false;
        }

         System.out.println(
        "Processing card payment for " + MoneyFormat.rands(amount)
        );

        return true;
    }

    @Override
    public String getPaymentType() {
        return "CARD";
    }
}
