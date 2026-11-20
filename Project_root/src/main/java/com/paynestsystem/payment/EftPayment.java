
package com.paynestsystem.payment;
import java.math.BigDecimal;
import com.paynestsystem.util.MoneyFormat;

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
    
        // Simulate an unsuccessful bank transfer
        if (simulateFailure) {
            System.out.println("EFT bank transfer failed.");
            return false;
        }

        System.out.println(
        "Processing EFT bank transfer for " + MoneyFormat.rands(amount));

        return true;
    }

    @Override
    public String getPaymentType() {
        return "EFT";
    }
}
