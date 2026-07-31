# 🏋️ Exercise 21 — Product Registry API (DTO to Entity Relationship)

## 📝 Description

Implement a REST API endpoint to register a new **Product** associated with an existing **Category**. The input JSON must contain a simple field named **categoryId**.

Your code must convert this request, associate the correct **Entity**, save the record, and return a read-only **Response DTO**.

---

# ⚙️ Technical Objectives

- Map a flat **Input DTO** (flat JSON) to a nested database relationship.
- Implement a proper architecture following this flow:
    - Controller
    - Service
    - Repository
- Return a specialized **Output DTO** instead of exposing **Entities** directly.

---

# 📂 Required Structure

## Entities

### Category

- id
- name

### Product

- id
- name
- price
- category

## DTOs

### ProductRequestDTO

- name
- price
- categoryId

### ProductResponseDTO

- id
- name
- price
- categoryName

---

# 🎯 HTTP Route and Method

## POST /products

Receives a **ProductRequestDTO**.

Returns:

**201 Created**

with a:

**ProductResponseDTO**

---

# 📋 Business Rules

- In the **Service** layer, retrieve the **Category** using the provided **categoryId**.
- If the **Category** is not found, throw a custom exception mapped to:
    - **404 Not Found**
- Convert the **ProductRequestDTO** into a **Product Entity**.
- Associate the **Product** with the retrieved **Category**.
- Save the **Product**.
- Convert the saved **Entity** into a **ProductResponseDTO** and return it.

---

# 🧪 Postman Test Case

## Request

**POST**

```http
http://localhost:8080/products
```

### JSON

```json
{
  "name": "Mechanical Keyboard",
  "price": 120.00,
  "categoryId": 2
}
```

---

# ✅ Expected Result (Success)

**Status:**

- **201 Created**

or

- **211 Created**

**Response Body:**

```json
{
  "id": 1,
  "name": "Mechanical Keyboard",
  "price": 120.00,
  "categoryName": "Peripherals"
}
```