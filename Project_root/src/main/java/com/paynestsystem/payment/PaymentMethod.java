
package com.paynestsystem.payment;

import java.math.BigDecimal;

/**
 * Implementations process payments and report their type.
 */
public interface PaymentMethod {

    /**
     * Processes a payment for the given amount.
     *
     * @param amount the amount to charge
     * @return true if payment succeeded, false otherwise
     */
    boolean processPayment(BigDecimal amount);

    /**
     * Returns the payment type.
     *
     * @return the payment type name
     */
    String getPaymentType();
}
