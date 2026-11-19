# PayNest: Merchant Order Desk and Unified Checkout

## 1. Overview

PayNest is a lightweight commerce kernel built using plain Java 21, without frameworks.

This repository contains **Capstone 1: Merchant Order Desk and Catalogue Engine** and **Capstone 3: Unified Checkout Across Payment Rails**.

The application manages customers, products and orders. It also allows customers to pay for an order using one of three supported payment methods: card, Electronic Funds Transfer (EFT), or digital wallet.

All payment methods use a single checkout flow through the `PaymentMethod` interface.

The design separates responsibilities:

- **Domain package:** Manages business entities, validation and order calculations.
- **Service package:** Generates formatted order summaries.
- **Payment package:** Handles payment processing through an interface and its concrete implementations.
- **Util package:** Holds `MoneyFormat`, the shared currency formatting helper used by the payment classes.
- **Application package:** Demonstrates the complete order and checkout workflow.

## 2. Project Structure

```text
merchant-order-desk-and-catalogue-engine-mmasellomanabile-umuzi/
├── README.md
├── .gitignore
├── Diagram/
│   └── ClassDiagram.pdf
└── Project_root/
    ├── pom.xml
    └── src/
        ├── main/java/com/paynestsystem/
        │   ├── app/
        │   │   └── PaynestApplication.java
        │   ├── domain/
        │   │   ├── Customer.java
        │   │   ├── Product.java
        │   │   ├── Order.java
        │   │   └── OrderItem.java
        │   ├── service/
        │   │   └── OrderService.java
        │   ├── payment/
        │   │   ├── PaymentMethod.java
        │   │   ├── CardPayment.java
        │   │   ├── EftPayment.java
        │   │   ├── WalletPayment.java
        │   │   └── PaymentProcessor.java
        │   └── util/
        │       └── MoneyFormat.java
        └── test/java/com/paynestsystem/
            ├── domain/
            │   ├── CustomerTest.java
            │   ├── OrderCheckoutTest.java
            │   ├── OrderItemTest.java
            │   ├── OrderTest.java
            │   └── ProductTest.java
            ├── payment/
            │   └── PaymentMethodTest.java
            ├── service/
            │   └── OrderServiceTest.java
            └── util/
                └── MoneyFormatTest.java
```

## 3. Features

### Customer and Product Management
- Create customers with validated names and email addresses.
- Create products with unique application-supplied IDs, names and prices.
- Reject invalid customer information and negative product prices.
- Store product prices to two decimal places.

### Order Management
- Create orders associated with customers.
- Add products to orders with validated quantities.
- Calculate individual order item subtotals.
- Calculate the grand total from order line items.
- Protect the internal order item collection using an unmodifiable list.
- Generate readable order summaries.

### Unified Payment Processing
- Process payments through a common `PaymentMethod` interface.
- Support card, EFT and wallet payment methods.
- Simulate successful and declined transactions.
- Validate payment methods and amounts through `PaymentProcessor`.
- Display payment success or failure messages.
- Prevent checkout of empty orders and zero-total orders.

## 4. Technologies Used

- Java 21
- Maven
- JUnit 5
- VS Code
- Git and GitHub

## 5. Prerequisites

Before running the application, ensure that you have:

- Java Development Kit (JDK) 21 or later.
- Apache Maven 3.9 or later.
- Git.

## 6. Getting Started

### Clone the repository

Open a terminal and run:

```bash
git clone https://github.com/Umuzi-skillslab/merchant-order-desk-and-catalogue-engine-mmasellomanabile-umuzi.git
```

Navigate to the project directory:

```bash
cd merchant-order-desk-and-catalogue-engine-mmasellomanabile-umuzi/Project_root
```

## 7. Running the Application

### Step 1: Compile the project

```bash
mvn clean compile
```

### Step 2: Run the application

```bash
mvn exec:java
```

### Expected Output

The demonstration creates an order containing two products and processes payment using the wallet payment method.

```text
Order Summary:
*********************************
Order: #1
Customer: Maxine Ramokgopa
Headsets x2 = R2,000.00
Keyboard x4 = R1,200.00
*********************************
Grand Total: R3,200.00
*********************************
Thank you for choosing us, Maxine Ramokgopa
*********************************
Processing wallet payment for R3200.00
Payment successful via WALLET
Amount: R3200.00
Order completed successfully.
```

The order summary uses a thousands separator, while payment messages display the amount to two decimal places.

## 8. Payment Architecture

### PaymentMethod Interface

The `PaymentMethod` interface defines the common contract for all supported payment methods.

It contains two methods:

```java
boolean processPayment(BigDecimal amount);

String getPaymentType();
```

Each payment implementation provides its own processing behaviour and payment type label.

### Payment Implementations

| Payment class | Payment type | Description |
|---|---|---|
| CardPayment | CARD | Simulates card payment processing. |
| EftPayment | EFT | Simulates an electronic funds transfer. |
| WalletPayment | WALLET | Simulates digital wallet payment processing. |

Each payment class supports simulated success and failure through its constructor.

For example:

```java
PaymentMethod paymentMethod = new CardPayment();
```

To simulate a declined card transaction:

```java
PaymentMethod paymentMethod = new CardPayment(true);
```

The same approach applies to EFT and wallet payments.

### PaymentProcessor

`PaymentProcessor` provides a single processing method:

```java
processPayment(PaymentMethod method, BigDecimal amount)
```

It is responsible for:

- Rejecting null payment methods.
- Rejecting null, zero and negative payment amounts.
- Delegating payment processing to the selected implementation.
- Displaying payment success or failure messages.
- Returning the payment result.

The processor works with the `PaymentMethod` interface rather than depending on individual payment classes.

### MoneyFormat

`MoneyFormat` is a public utility class in the `com.paynestsystem.util` package. It centralises currency formatting so the payment classes do not each repeat it.

It ensures that payment amounts are displayed consistently in South African Rand (R) to two decimal places.

It sits in `util` rather than `payment` because currency formatting is a general helper, not a payment rule. Keeping it separate means other packages can reuse it without depending on the payment package.

## 9. How Checkout Works

The checkout process follows these steps:

1. The application creates a customer, products and an order.
2. Products are added to the order with their respective quantities.
3. `OrderService` generates the formatted order summary.
4. The application selects a payment method through the `PaymentMethod` interface.
5. `Order.checkout()` calculates the order total.
6. Empty orders are rejected, and zero-total orders are prevented from proceeding to payment.
7. The calculated total is passed to `PaymentProcessor`.
8. `PaymentProcessor` validates the payment method and amount.
9. The selected payment implementation processes the transaction.
10. The processor reports whether payment succeeded or failed.
11. The order displays the appropriate checkout result.

### Payment Failure Handling

The application supports simulated payment failures.

For example, a declined card transaction produces output similar to:

```text
Card payment declined.
Payment failed via CARD
Please try again or select another payment method.
Order checkout failed.
```

A failed transaction does not produce a successful order completion message.

### Zero-Total Order

An order with a total of zero cannot proceed to checkout.

Example output:

```text
Order checkout failed: order total must be greater than zero.
```

## 10. Validation and Business Rules

Validation is implemented across the domain and payment layers.

### Domain Validation

- Customer names and emails cannot be null or blank.
- Product names cannot be null or blank.
- Product prices cannot be null or negative.
- Order customers cannot be null.
- Order products cannot be null.
- Order quantities must be greater than zero.
- Empty orders cannot be checked out.

### Payment Validation

`PaymentProcessor` validates the payment method and amount before invoking a payment implementation.

It rejects:

- Null payment methods.
- Null payment amounts.
- Zero payment amounts.
- Negative payment amounts.

Invalid payment requests result in an `IllegalArgumentException`.

## 11. Automated Testing

The project uses JUnit 5 for automated testing.

Run the tests from the `Project_root` directory:

```bash
mvn clean test
```

### Test Coverage

The automated tests cover:

- Customer validation.
- Product validation and price rounding.
- Order item calculations and invalid quantities.
- Order total calculations.
- Empty order checkout.
- Successful payments using card, EFT and wallet.
- Failed payment transactions.
- Payment processing through the `PaymentMethod` interface.
- Verification that checkout charges the calculated order total.
- Invalid payment methods and payment amounts.
- Zero-total orders.
- Protection of the internal order item collection.
- Order summary generation.
- Currency formatting through `MoneyFormat`, including the R prefix and rounding to two decimal places.

### Latest Test Results

The project was successfully tested using Maven after cloning the GitHub repository into a fresh directory.

```text
Tests run: 33, Failures: 0, Errors: 0, Skipped: 0

BUILD SUCCESS
```

All 33 tests passed across eight test classes.

## 12. Core Design Decisions

### Why Use an Interface Instead of One Mega-Method?

Using one large payment method with multiple `if` or `switch` statements would make the checkout process increasingly difficult to maintain as new payment methods are introduced.

The `PaymentMethod` interface provides a common contract that allows different payment implementations to be processed through the same checkout flow.

Each concrete payment class is responsible for its own payment-specific behaviour, message and label.

`Order` and `PaymentProcessor` work with the interface rather than depending on specific payment implementations.

This makes the system easier to extend. For example, adding a `BuyNowPayLaterPayment` implementation would require a new payment class and application wiring, without changing the existing order total calculation or payment processor.

### Encapsulation

Each `OrderItem` calculates its own subtotal using its product price and quantity.

The `Order` calculates the grand total by adding the subtotals of its order items.

This keeps calculation responsibilities close to the relevant domain objects.

### Separation of Concerns

The project separates responsibilities into packages:

- **Domain:** Holds business entities and their validation rules.
- **Service:** Generates formatted order summaries.
- **Payment:** Handles payment processing and payment-specific behaviour.
- **Util:** Holds shared helpers that are not tied to one layer, currently `MoneyFormat`.
- **Application:** Demonstrates the application workflow.

### Money Handling

The starter implementation used `double` for payment amounts.

This project uses `BigDecimal` because binary floating-point arithmetic cannot represent some decimal values exactly.

Product prices are stored to two decimal places using `RoundingMode.HALF_UP`.

This provides more appropriate monetary precision for order calculations and payment processing.

## 13. Known Limitations

- Payments are simulated. No real payment gateway, bank account, card details or wallet balances are connected.
- Product prices of zero are permitted, but orders with a zero total cannot be checked out.
- Checkout does not maintain an order payment status. Calling checkout more than once can process the same order again.
- The application does not capture or validate actual card numbers, bank account details or wallet credentials.
- The current application demonstrates one selected payment method at a time.

## 14. Future Improvements

Possible future extensions include:

- Introducing additional payment methods, such as Buy Now Pay Later.
- Adding order payment status tracking.
- Preventing repeated payment processing for completed orders.
- Introducing discounts, taxes and shipping costs.
- Adding stock management.
- Integrating real payment gateways when required.

## 15. System Design

The project includes a class diagram in the `Diagram` folder.

[View ClassDiagram.pdf](Diagram/ClassDiagram.pdf)

The diagram illustrates the relationships between:

- Customer
- Product
- Order
- OrderItem
- OrderService
- PaymentMethod
- CardPayment
- EftPayment
- WalletPayment
- PaymentProcessor
- MoneyFormat

It also demonstrates the implementation relationships between the payment interface and its concrete payment classes, and shows `MoneyFormat` in the separate `util` package as a dependency of the payment classes.

## 16. Author

**Mmasello Manabile**

PayNest – Merchant Order Desk and Unified Checkout

Java 21 | Maven | JUnit 5