# 🏋️ Exercise 22 — Paginated Catalog Delivery

## 📝 Description

Create a customer-facing API endpoint that allows searching **Products** by category, with optional support for sorting and pagination.

The response JSON must not expose internal database details, but instead return a clean structure using pageable DTO structures.

## ⚙️ Technical Objectives

- Use `Pageable` directly as a Controller parameter.
- Map page elements using:

```java
Page.map()
```

to safely perform the transition from:

```text
Entity -> DTO
```

## 📂 Required Structure

### Entities and DTOs

Use the same structures from **Exercise 21**.

## 🎯 HTTP Route and Method

```http
GET /products?categoryId=2&page=0&size=5&sort=name,asc
```

**Response:**

```text
200 OK
```

## 📋 Business Rules

- Receive `categoryId` and a `Pageable` parameter in the Controller.
- Query the Repository using a custom method (or query method) to retrieve the products belonging to the specified category.
- Transform:

```java
Page<Product>
```

into:

```java
Page<ProductResponseDTO>
```

using:

```java
.map()
```

from Spring's `Page` class.

## 🧪 Postman Test Case

**Request:**

```http
GET http://localhost:8080/products?categoryId=2&page=0&size=2
```

**Expected Result:**

```text
200 OK
```

with the standard Spring pagination structure containing the items as:

```json
{
  "content": [
    {
      "id": 1,
      "name": "Gaming Mouse",
      "price": 80.00,
      "categoryName": "Peripherals"
    },
    {
      "id": 2,
      "name": "Mechanical Keyboard",
      "price": 120.00,
      "categoryName": "Peripherals"
    }
  ],
  "totalPages": 5,
  "totalElements": 10
}
```