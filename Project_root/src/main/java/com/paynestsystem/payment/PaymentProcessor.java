

package com.paynestsystem.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Processes payments using any PaymentMethod implementation.
 * Validates transactions and handles payment results.
 */
public class PaymentProcessor {

    /**
     * Processes a payment using the selected payment method.
     *
     * @param method the payment method to use
     * @param amount the amount to charge
     * @return true if payment succeeds, false otherwise
     */
    public boolean processPayment(
            PaymentMethod method,
            BigDecimal amount) {

        // Validate payment method
        if (method == null) {
            throw new IllegalArgumentException(
                "Payment method cannot be null"
            );
        }

        // Validate payment amount
        if (amount == null ||
                amount.compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException(
                "Amount must be greater than zero"
            );
        }

        // Process payment
        boolean success = method.processPayment(amount);

        // Handle payment result
        if (success) {

            System.out.println(
                "Payment successful via " + method.getPaymentType()
            );

            System.out.println(
                "Amount: R" +
                amount.setScale(2, RoundingMode.HALF_UP).toPlainString()
            );

        } else {

            System.out.println(
                "Payment failed via " + method.getPaymentType()
            );

            System.out.println(
                "Please try again or select another payment method."
            );
        }

        return success;
    }
}
