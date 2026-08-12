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

project-root
│
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── paynestsystem
│   │               ├── app
│   │               │   └── PaynestApplication.java
│   │               ├── domain
│   │               │   ├── Customer.java
│   │               │   ├── Order.java
│   │               │   ├── OrderItem.java
│   │               │   └── Product.java
│   │               └── service
│   │                   └── OrderService.java
│   │
│   └── test
│       └── java
│           └── com
│               └── paynestsystem
│                   └── domain
│                       ├── OrderItemTest.java
│                       └── OrderTest.java
│
└── docs
    └── ERDiagram.png


### Package Descriptions

| Package | Description |
|----------|-------------|
| `app` | Contains the application entry point. |
| `domain` | Contains core business entities such as Customer, Product, Order, and OrderItem. |
| `service` | Contains business logic and presentation-related services. |

## Technologies Used

- Java 21
- Maven
- JUnit 5
- VS Code

## Prerequisites

Before running the project, ensure you have:

- Java 17 or later
- Maven 3.9 or later
- Git

## Getting Started

### Clone the Repository
on bash/terminal: 

git clone https://github.com/Umuzi-skillslab/merchant-order-desk-and-catalogue-engine-mmasellomanabile-umuzi.git


Navigate to the project folder:

on bash/ terminal: 

cd merchant-order-desk-and-catalogue-engine-mmasellomanabile-umuzi

## Running the Application

# Option 1: Run from the Terminal

1. Compile the project:

- on bash/terminal run: 
mvn clean compile


2. Run the application:

on bash/ terminal run: 
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

Example: 
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0


## Core Design Principles

PayNest is designed with extensibility and maintainability in mind.

### Encapsulation

Each `OrderItem` is responsible for calculating its own subtotal, ensuring that calculation logic remains close to the data it represents.

### Separation of Concerns

The project separates:

- Domain Layer: Business rules and data models
- Service Layer: Formatting and presentation logic

This keeps the codebase clean and easier to maintain.

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
