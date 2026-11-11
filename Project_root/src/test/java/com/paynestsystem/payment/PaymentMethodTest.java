// src/test/java/com/paynestsystem/payment/PaymentMethodTest.java
package com.paynestsystem.payment;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.Test;

class PaymentMethodTest {

    @Test
    void everyRailProcessesAPaymentThroughTheInterface() {
        BigDecimal amount = new BigDecimal("12400");
        List<PaymentMethod> rails =
                List.of(new CardPayment(), new EftPayment(), new WalletPayment());

        for (PaymentMethod rail : rails) {
            assertTrue(rail.processPayment(amount));
        }
    }

    @Test
    void eachRailHasItsOwnStableLabel() {
        assertEquals("CARD", new CardPayment().getPaymentType());
        assertEquals("EFT", new EftPayment().getPaymentType());
        assertEquals("WALLET", new WalletPayment().getPaymentType());
    }

    @Test
    void processorRejectsNullMethodAndNonPositiveAmount() {
        PaymentProcessor processor = new PaymentProcessor();

        assertThrows(IllegalArgumentException.class,
                () -> processor.processPayment(null, BigDecimal.TEN));
        assertThrows(IllegalArgumentException.class,
                () -> processor.processPayment(new CardPayment(), BigDecimal.ZERO));
    }

    @Test
    void processorReportsFailedPayment() {
        PaymentMethod failing = new PaymentMethod() {
            public boolean processPayment(BigDecimal amount) { return false; }
            public String getPaymentType() { return "TEST"; }
        };
        assertFalse(new PaymentProcessor().processPayment(failing, BigDecimal.TEN));
    }
}