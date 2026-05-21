# 🏋️ Exercise 02 — Basic Product Filtering

## 📝 Description

A store needs an endpoint where users can filter products by category using Query Parameters. If no category is provided, the system must return all products.

---

## ⚙️ Technical Objectives

- Practice using simple `@RequestParam`.
- Learn how to make a query parameter optional using `required = false`.

---

## 📂 Required Structure

### Class: `Product`

#### Fields
- `id`
- `name`
- `category`
- `price`

> **Note:** Create a static list of products with mixed categories (e.g., `"MOVIES"`, `"BOOKS"`).

---

## 🎯 Routes and HTTP Methods

### `GET /products`

---

## 📋 Business Rules

- If the client sends the parameter `?category=MOVIES`, filter the list and return only products from that category with status `200 OK`.

- If the client calls the endpoint without parameters (`/products`), return the full product list with status `200 OK`.

---

## 🧪 Postman Test Cases

### With Filter

```http
GET http://localhost:8080/products?category=Books
```

✅ **Expected Result:** Only book products should be returned.

---

### Without Filter

```http
GET http://localhost:8080/products
```

✅ **Expected Result:** All products from the list should be returned.