
package com.paynestsystem.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.paynestsystem.payment.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderCheckoutTest {

    /** Test rail: records the amount it was asked to charge. */
    private static class RecordingPayment implements PaymentMethod {
        BigDecimal received;
        final boolean result;

        RecordingPayment(boolean result) {
            this.result = result;
        }

        @Override
        public boolean processPayment(BigDecimal amount) {
            received = amount;
            return result;
        }

        @Override
        public String getPaymentType() {
            return "TEST";
        }
    }

    private Order order;

    @BeforeEach
    void setUp() {
        Customer customer = new Customer(1, "Maxine", "maxine@umuzi.org");
        order = new Order(1, customer);
        order.addItem(new Product(1, "Headsets", BigDecimal.valueOf(1000)), 2);
        order.addItem(new Product(2, "Keyboard", BigDecimal.valueOf(300)), 4);
    }

    @Test
    void checkoutChargesExactlyTheOrderTotal() {
        RecordingPayment rail = new RecordingPayment(true);

        order.checkout(rail);

        assertEquals(0, rail.received.compareTo(order.calculateTotal()));
        assertEquals(0, rail.received.compareTo(BigDecimal.valueOf(3200)));
    }

    @Test
    void checkoutWorksWithDifferentRails() {
        assertDoesNotThrow(() -> order.checkout(new CardPayment()));
        assertDoesNotThrow(() -> order.checkout(new EftPayment()));
        assertDoesNotThrow(() -> order.checkout(new WalletPayment()));
    }

    @Test
    void failedPaymentIsReported() {
        PrintStream original = System.out;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captured));
        try {
            order.checkout(new RecordingPayment(false));
        } finally {
            System.setOut(original);
        }
        assertTrue(captured.toString().contains("Order checkout failed."));
    }

    @Test
    void nullPaymentMethodAndEmptyOrderAreRejected() {
        assertThrows(IllegalArgumentException.class, () -> order.checkout(null));

        Order empty = new Order(2, new Customer(2, "Sam", "sam@umuzi.org"));
        assertThrows(IllegalStateException.class,
                () -> empty.checkout(new CardPayment()));
    }

    @Test
    void itemListCannotBeModifiedFromOutside() {
        assertThrows(UnsupportedOperationException.class,
                () -> order.getItems().clear());
    }
}