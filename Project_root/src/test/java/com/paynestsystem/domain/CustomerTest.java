package com.paynestsystem.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    void testValidCustomer() {

        Customer customer = new Customer(
                1,
                "Maxine",
                "maxine@umuzi.org"
        );

        assertEquals(1, customer.getId());
        assertEquals("Maxine", customer.getName());
        assertEquals("maxine@umuzi.org", customer.getEmail());
    }

    @Test
    void testBlankNameThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Customer(
                        1,
                        " ",
                        "maxine@umuzi.org"
                )
        );
    }

    @Test
    void testBlankEmailThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Customer(
                        1,
                        "Maxine",
                        " "
                )
        );
    }

    @Test
    void testNullNameThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Customer(
                        1,
                        null,
                        "maxine@umuzi.org"
                )
        );
    }

    @Test
    void testNullEmailThrowsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Customer(
                        1,
                        "Maxine",
                        null
                )
        );
    }
}