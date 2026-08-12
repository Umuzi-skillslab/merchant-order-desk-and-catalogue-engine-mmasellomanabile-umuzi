# PayNest Merchant Order Desk & Catalogue Engine: Capstone 1

## Overview

PayNest is a lightweight commerce engine built with Java 21 that manages customers, products, and orders using clear domain-driven design principles.

The project demonstrates strong Object-Oriented Programming (OOP) practices by separating domain logic from presentation concerns. Domain classes encapsulate business rules and data, while the service layer handles formatting and output.

## Features

- Create customers

- Create products

- Create orders

- Add items to orders

- Generate and display order summaries

- Demonstrates clean OOP design principles


## Project Structure

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

### Package Descriptions

| Package | Description |
|----------|-------------|
| app | Contains the application entry point. |
| domain | Contains core business entities such as Customer, Product, Order, and OrderItem. |
| service | Contains business logic and presentation-related services. |

## Technologies Used

- Java 21
- Maven
- JUnit 5
- VS Code

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

mvn exec:java

### Option 2: Run from Your IDE

Open:
PaynestApplication.java

and click "Run".

The generated order summary will be displayed in the console/output terminal.


## Running Tests

Execute all tests with:

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



## Learner

Mmasello Manabile
