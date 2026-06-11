# 🏋️ Exercise 27 — Session-Based Shopping Cart Simulation (Scopes)

## 📝 Description

You will create a simulation endpoint where a component tracks consecutive requests. The goal is to use bean scopes to understand how Spring Beans behave when data changes across multiple HTTP calls.

## ⚙️ Technical Objectives

- Compare the behavior of stateful Beans by analyzing the effects of `Singleton` versus `Prototype` scopes when using volatile in-memory persistence.

## 📂 Required Structure

Component/Class:

- `CounterBean` (Contains a simple attribute `private int count = 0;` and an `increment()` method.)
- Test this class by switching between `@Scope("singleton")` and `@Scope("prototype")`.

Class:

- `CounterController`

## 🎯 Routes and HTTP Methods

### POST `/counter/click`

## 📋 Functional Requirements

- Inject `CounterBean` into your Controller.
- Inside the endpoint method, call `counter.increment()` and return the updated value.
- Practical challenge:
    - Run the project with the Bean configured as `Singleton` and call the endpoint 5 times using Postman. Observe the counter increasing.
    - Then change the Bean to `Prototype`, restart the project, and call the endpoint 5 more times. The counter should never go above `1`.

## 🧪 Postman Test Cases

### Singleton Mode

The counter accumulates values:

```text
1, 2, 3...
```

### Prototype Mode

The counter remains at:

```text
1
```

on every request, demonstrating that Spring creates a new object for each request.