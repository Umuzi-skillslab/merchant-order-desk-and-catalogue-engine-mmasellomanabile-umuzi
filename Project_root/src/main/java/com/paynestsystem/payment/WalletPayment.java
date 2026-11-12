

package com.paynestsystem.payment;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The user makes a payment via digital wallet.
 */
public class WalletPayment implements PaymentMethod {

    private final boolean simulateFailure;

    public WalletPayment() {
        this(false);
    }

    public WalletPayment(boolean simulateFailure) {
        this.simulateFailure = simulateFailure;
    }

    @Override
    public boolean processPayment(BigDecimal amount) {

        // Validate payment amount
        if (amount == null ||
                amount.compareTo(BigDecimal.ZERO) <= 0) {

            System.out.println("Wallet payment failed: Invalid amount.");
            return false;
        }

        // Simulate an unsuccessful wallet transaction
        if (simulateFailure) {
            System.out.println("Wallet payment failed: Transaction declined.");
            return false;
        }

        System.out.println(
            "Processing wallet payment for R" +
            amount.setScale(2, RoundingMode.HALF_UP).toPlainString()
        );

        return true;
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}
