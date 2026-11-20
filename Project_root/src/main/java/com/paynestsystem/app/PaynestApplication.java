package com.paynestsystem.app;

import com.paynestsystem.domain.Customer;
import com.paynestsystem.domain.Order;
import com.paynestsystem.domain.Product;
import com.paynestsystem.service.OrderService;
import com.paynestsystem.payment.PaymentMethod;
import com.paynestsystem.payment.CardPayment;
import com.paynestsystem.payment.EftPayment;
import com.paynestsystem.payment.WalletPayment;
import java.math.BigDecimal;

public class PaynestApplication {

    public static void main(String[] args) {

        Product prod1 = new Product(1, "Headsets", BigDecimal.valueOf(1000));
        Product prod2 = new Product(2, "Keyboard",BigDecimal.valueOf(300));

        Customer customer =
                new Customer(1,
                        "Maxine Ramokgopa",
                        "maxineR@umuzi.org");

        Order order = new Order(1, customer);

        order.addItem(prod1, 2);
        order.addItem(prod2, 4);

        OrderService service = new OrderService();
        System.out.println(service.generateOrderSummary(order));

        // Choose payment method
        PaymentMethod paymentMethod = new WalletPayment();

        // Checkout
        order.checkout(paymentMethod);
    }
}