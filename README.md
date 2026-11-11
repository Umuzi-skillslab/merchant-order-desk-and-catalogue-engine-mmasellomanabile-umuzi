# PayNest: Merchant Order Desk and Unified Checkout

## Overview

PayNest is a lightweight commerce kernel built in plain Java 21 (no frameworks). It manages customers, products and orders, and lets an order be paid through any supported payment rail (card, EFT or wallet) using one checkout flow. The design separates concerns: domain classes hold data and business rules, the service layer handles presentation and formatting, and the payment package hides rail-specific behaviour behind a single interface.

## Project Structure

<<<<<<< HEAD
```
Project_root/
├── pom.xml
└── src/
    ├── main/java/com/paynestsystem/
    │   ├── app/      PaynestApplication (demo entry point)
    │   ├── domain/   Customer, Product, Order, OrderItem
    │   ├── service/  OrderService (prints the order summary)
    │   └── payment/  PaymentMethod, CardPayment, EftPayment,
    │                 WalletPayment, PaymentProcessor
    └── test/java/com/paynestsystem/   JUnit 5 tests
```

## Features
=======
src
├── main
│   └── java
│       └── com
│           └── paynestsystem
│               ├── app
│               │   └── PayNestApplication.java
│               │
│               ├── domain
│               │   ├── Customer.java
│               │   ├── Order.java
│               │   ├── OrderItem.java
│               │   └── Product.java
│               │
│               └── service
│                   └── OrderService.java
│
└── test
    └── java
        └── com
            └── paynestsystem
                ├── domain
                │   ├── CustomerTest.java
                │   ├── OrderItemTest.java
                │   ├── OrderTest.java
                │   └── ProductTest.java
                │
                └── service
                    └── OrderServiceTest.java
>>>>>>> 3b5781837c91bf811c4d126f2add762352413bef

- Create customers and products
- Create orders and add items (quantities must be greater than 0)
- Calculate the order total from its line items
- Print a readable order summary
- Check out with any payment rail through the `PaymentMethod` interface
- Reject invalid input (null or empty values, empty orders, null payment methods)

<<<<<<< HEAD
## Technologies
=======
| Package | Description |
|----------|-------------|
| app | Contains the application entry point. |
| domain | Contains core business entities such as Customer, Product, Order, and OrderItem. |
| service | Contains business logic and presentation-related services. |

## Technologies Used
>>>>>>> 3b5781837c91bf811c4d126f2add762352413bef

- Java 21
- Maven
- JUnit 5
- VS Code

<<<<<<< HEAD
## Running the Application

Prerequisites: JDK 21 and Apache Maven installed.

1. Clone the repository: `https://github.com/Umuzi-skillslab/merchant-order-desk-and-catalogue-engine-mmasellomanabile-umuzi.git`

2. Open a terminal in the `Project_root` folder (the one containing `pom.xml`).
3. Run:

```bash
mvn clean compile
=======
## Prerequisites

Before running the project, ensure you have:

- Java 21 or later
- Maven 3.9 or later
- Git

## Getting Started

### Clone the Repository
on bash/terminal: 

git clone https://github.com/Umuzi-skillslab/merchant-order-desk-and-catalogue-engine-mmasellomanabile-umuzi.git


Navigate to the project folder:

on bash/ terminal: 

cd merchant-order-desk-and-catalogue-engine-mmasellomanabile-umuzi
cd Project_root

## Running the Application

# Option 1: Run from the Terminal
1. Access the project via: cd Project_root

2.  Compile the project:

mvn clean compile

3. Run the application:

>>>>>>> 3b5781837c91bf811c4d126f2add762352413bef
mvn exec:java
```

Alternatively, open `PaynestApplication.java` in VS Code and click the Run button. The output appears in the terminal.


Please Note: amounts use your system's regional settings for the decimal separator, so on a South African locale you will see `R3200,00` instead of `R3200.00`. This is expected.

## Expected Output

<<<<<<< HEAD
        Order Summary:
        *********************************
        Customer: Maxine Ramokgopa
        Headsets x2 = R2000.00
        Keyboard x4 = R1200.00
        ****************************************
        Your total is: R3200.00
        ****************************************
        Thank you for choosing us Maxine Ramokgopa
        ****************************************
        Processing card payment for R3200.00
        Payment successful via CARD
        Amount: R3200.00
        Order completed successfully.
=======
* On bash run: 
mvn test

### Expected Output
mvn test should finish with BUILD SUCCESS. 


## Core Design Principles

PayNest is designed with extensibility and maintainability in mind.

### Encapsulation

Each OrderItem is responsible for calculating its own subtotal, ensuring that calculation logic remains close to the data it represents.

### Separation of Concerns

The project separates:

- Domain Layer: Business rules and data models
- Service Layer: Formatting and presentation logic

This keeps the codebase clean and easier to maintain.

## Extensibility

The system separates product data, order lines, order calculations, and presentation.

A Product contains catalogue information such as its ID, name, and price. An
`OrderItem` combines a product with a quantity and is responsible for calculating
its line subtotal. The Order calculates the grand total by summing the subtotals of its order items.

Because the order calculation depends on the existing product price behaviour
rather than individual catalogue fields, new product information such as SKU, description, category, or stock information can be added to Product without rewriting the core checkout calculation.

The service layer is responsible for generating the human-readable order
summary, keeping presentation concerns separate from the domain model.

### Future Scalability

The current design makes it straightforward to add features such as:

- Discounts
- Taxes
- Shipping costs
- Promotions
- Additional reporting services

These enhancements can be introduced through new classes or services without changing the existing order-processing logic.


## System Design

The project's Entity Relationship/Class Diagram can be found here:

docs/ERDiagram.png
>>>>>>> 3b5781837c91bf811c4d126f2add762352413bef



## Tests

Run `mvn test` from `Project_root`.

Expected result: `BUILD SUCCESS` with no failures or errors. The tests cover:

- line and order totals, invalid quantities and null products
- every payment rail through the `PaymentMethod` interface
- checkout charging exactly the order total (using a custom test rail)
- failed payments, null payment methods, empty orders and the read-only item list

## How Checkout Works

`Order.checkout(PaymentMethod)` calculates the order total once and passes it to `PaymentProcessor`, which calls `processPayment(amount)` on whichever rail it was given and prints the result. To switch rails, change only the line in `PaynestApplication` that creates the payment method: `new CardPayment()`, `new EftPayment()` or `new WalletPayment()`.

## Core Design

Each `OrderItem` calculates its own subtotal and the `Order` adds those up, so features such as discounts, tax or shipping can be added in new classes or services without rewriting existing code. The domain classes focus on business rules, while the service layer takes care of presentation and formatting. This keeps the core clean and avoids mixing responsibilities.


### Why an interface and not one mega-method

A single payment method full of `if (card) ... else if (eft) ...` branches has to be edited every time a rail is added, and each edit risks breaking rails that already work. With the `PaymentMethod` interface, `Order` and `PaymentProcessor` depend only on the contract "process this amount", and each rail owns its own label and message. Adding a `BuyNowPayLaterPayment` rail would mean writing one new class and changing one line in the demo. The order total calculation is never touched.

### Money handling

Prices are rounded to 2 decimal places (RoundingMode.HALF_UP) when a Product is created, so every line total and the grand total reconcile exactly. The brief’s starter code used double; BigDecimal is used instead as required by the assessors.

## Author

Mmasello Manabile