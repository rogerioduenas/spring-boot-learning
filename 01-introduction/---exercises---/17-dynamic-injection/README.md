# 🏋️ Exercise 17 — Dynamic Injection with External Properties (`@Value`)

## 📝 Description

Modify the behavior of a business rule in your Service layer (such as charging a fixed shipping fee) without changing the Java code. The value must be read directly from the `application.yaml` configuration file.

---

## ⚙️ Technical Objectives

- Practice reading configuration values from external files using `@Value`.

---

## 📂 Required Structure

### Configuration File

#### `application.yaml`

Add a custom property, for example:

```yaml
app:
  shipping:
    fixed-fee: 15.90
```

### Classes

- `ShippingService` (where the `@Value` annotation is injected)
- `ShippingController`

---

## 🎯 HTTP Routes and Methods

### GET `/shipping/calculate?productValue=100.0`

---

## 📋 Business Rules

1. The Service must receive the product value as input.
2. Read the fixed shipping fee from `application.yaml` using `@Value`.
3. Add the shipping fee to the product value.
4. Return the calculated total amount.
5. The Controller must return the result with HTTP status **200 OK**.

---

## 🧪 Postman Test Cases

### Request

```http
GET http://localhost:8080/shipping/calculate?productValue=100.0
```

### Expected Result

A JSON response indicating that the total amount is **115.90**, proving that Spring successfully loaded the value from the YAML configuration file.

Example:

```json
{
  "productPrice": 100.0,
  "shippingFee": 15.90,
  "total": 115.90
}
```