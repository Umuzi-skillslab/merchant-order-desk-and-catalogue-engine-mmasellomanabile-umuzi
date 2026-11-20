package com.paynestsystem.payment;

import java.math.BigDecimal;
import com.paynestsystem.util.MoneyFormat;


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

        // Simulate an unsuccessful wallet transaction
        if (simulateFailure) {
            System.out.println("Wallet payment failed: Transaction declined.");
            return false;
        }

       System.out.println(
        "Processing wallet payment for " + MoneyFormat.rands(amount));

        return true;
    }

    @Override
    public String getPaymentType() {
        return "WALLET";
    }
}
