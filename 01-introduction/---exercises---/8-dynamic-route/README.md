# 🏋️ Exercise 08 — Multi-Purpose Dynamic Route (PathVariable Map)

## 📝 Description

Map a flexible route capable of capturing multiple complex path variables from a URL at once, without needing to declare each variable individually in the method arguments.

---

## ⚙️ Technical Objectives

- Practice capturing all path variables using `@PathVariable Map<String, String>`.

---

## 🎯 Routes and HTTP Methods

```http
GET /categories/{main}/subcategories/{sub}/{productName}
```

---

## 📋 Business Rules

- Declare the route containing the three variables shown above.
- Capture all variables using a single `Map`.
- Return this map directly in the response body to verify that Spring correctly distributed the keys `{main}`, `{sub}`, and `{productName}` inside the map.

---

## 🧪 Postman Test Cases

### Request

```http
GET http://localhost:8080/categories/electronics/subcategories/smartphones/iphone15
```

---

## ✅ Expected Result

The returned JSON must contain the mapped keys with their respective values extracted from the URL.

### Example Response

```json
{
  "main": "electronics",
  "sub": "smartphones",
  "productName": "iphone15"
}
```