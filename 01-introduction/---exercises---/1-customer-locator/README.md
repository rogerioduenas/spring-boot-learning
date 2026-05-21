# 🏋️ Exercise 01 — The Customer Locator

## 📝 Description

A system must retrieve customers from memory based on the ID provided directly in the URL.  
If the customer does not exist, the API must return only the corresponding HTTP status code with an empty response body.

---

## ⚙️ Technical Objectives

- Practice using `@RestController` and `@GetMapping`
- Practice capturing dynamic URL variables with a simple `@PathVariable`
- Practice controlling HTTP status codes using `ResponseEntity`

---

## 📂 Required Structure

### Class: `Customer`

Fields:

- `id`
- `name`
- `email`

> **Note:** Create a static list containing 2 or 3 customers inside your Controller to simulate a temporary in-memory database.

---

## 🎯 Routes and HTTP Verbs

### `GET /customers/{id}`

---

## 📋 Business Rules

- If the `id` provided in the URL exists in the list, return the customer object with status `200 OK`
- If the `id` does not exist, return an empty body with status `404 NOT FOUND`

---

## 🧪 Postman Test Cases

### ✅ Success Case

```http
GET http://localhost:8080/customers/1
```

**Expected Result:**

- Customer JSON response
- Status `200 OK`

---

### ❌ Failure Case

```http
GET http://localhost:8080/customers/999
```

**Expected Result:**

- Empty response body
- Status `404 NOT FOUND`