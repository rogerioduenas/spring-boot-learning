# 🏋️ Exercise 27 — Read-Only Report API

## 📝 Description

Build an endpoint that generates a read-only list of financial metrics. Configure the API so that Hibernate optimizes memory usage and completely prevents any data modifications, throwing an error if a developer attempts to update records during the report execution.

---

## ⚙️ Technical Objectives

- Configure a read-only transactional context in the service layer.
- Prevent accidental write operations during read-intensive workflows.

---

## 📂 Required Structure

### Entities

- **FinancialRecord**
    - `id`
    - `description`
    - `amount`

---

## 🎯 Endpoint

### `GET /reports/financial`

**Response**

- Return **200 OK**.

---

## 📋 Business Rules

The service layer method must be annotated with:

```java
@Transactional(readOnly = true)
```

The implementation must:

1. Retrieve the records.
2. Convert them to DTOs.
3. Return the list.

---

## ✅ Proof of Concept

Even if someone modifies the state of a `FinancialRecord` before converting it to a DTO, those changes must **not** be persisted to the database.

---

# 🧪 Test Case (Postman)

## Request

```http
GET http://localhost:8080/reports/financial
```

## Expected Result

- **Status:** `200 OK`
- No SQL `UPDATE` statements should be executed, even if entity properties are temporarily modified during the transaction.