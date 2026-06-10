# 🏋️ Exercise 23 — Automatic Auditing with AOP (`@Before`)

## 📝 Description

Many companies require logging information about who is accessing sensitive data. You will create an Aspect that intercepts requests and prints security-related information to the console before a financial Controller method is executed.

## ⚙️ Technical Objectives

- Reinforce the concepts of Aspect-Oriented Programming (AOP).
- Use the `@Before` annotation with a targeted Pointcut expression.

## 📂 Required Structure

Controller Class:

- `FinanceController` (with the route `GET /finance/revenue`)

Aspect Class:

- `AuditAspect` (annotated with `@Aspect` and `@Component`)

## 🎯 Routes and HTTP Methods

### GET `/finance/revenue`

## 📋 Functional Requirements

- Your Aspect must intercept any method execution within `FinanceController`.
- In the method annotated with `@Before`, use the `JoinPoint` object to capture and print the name of the invoked method using `System.out.println`.
- The Controller should simply return a string containing financial data with status **200 OK**.

## 🧪 Postman Test Cases

Call the endpoint using Postman.

The response should be returned normally (**200 OK**), but check your IDE terminal: the message printed by your `@Before` advice should appear there milliseconds before the Controller method is executed.