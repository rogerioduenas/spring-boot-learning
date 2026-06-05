# 🏋️ Exercise 18 — Duplicate Registration with HTTP 409 Conflict

## 📝 Description

Simulate unique email validation using an in-memory data store. If a client attempts to register an email address that already exists in the list, the API must return the appropriate conflict status code.

---

## ⚙️ Technical Objectives

- Practice using the HTTP **409 Conflict** status code for duplicate resources.
- Handle uniqueness rule violations through a global `ControllerAdvice`.

---

## 📂 Required Structure

### Entity

#### `Client`

```java
public class Client {
    private Long id;
    private String name;
    private String email;
}
```

### Custom Exception

#### `EmailDuplicatedException`

A custom exception that should be thrown whenever a registration attempt uses an email address that already exists.

---

## 🎯 HTTP Routes and Methods

### POST `/clients`

---

## 📋 Business Rules

1. The Service layer must maintain a static in-memory list of clients.
2. When a new `Client` is received, the Service must verify whether the email address already exists.
3. If the email is already registered:
    - Stop the execution flow.
    - Throw an `EmailDuplicatedException`.
4. The global exception handler (`@RestControllerAdvice`) must catch the exception and return:
    - HTTP Status: **409 Conflict**
    - An appropriate error message explaining that the email is already registered.

---

## 🧪 Postman Test Cases

### Test 1 — Successful Registration

#### Request

```http
POST http://localhost:8080/clients
```

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "user@email.com"
}
```

#### Expected Result

**HTTP Status:** `201 Created`

Example Response:

```json
{
  "id": 1,
  "name": "John Doe",
  "email": "user@email.com"
}
```

---

### Test 2 — Duplicate Registration

#### Request

```http
POST http://localhost:8080/clients
```

```json
{
  "id": 2,
  "name": "Jane Doe",
  "email": "user@email.com"
}
```

#### Expected Result

**HTTP Status:** `409 Conflict`

Example Response:

```json
{
  "message": "Email address is already registered."
}
```

This response confirms that the API correctly detected the uniqueness violation and returned the appropriate HTTP status code.