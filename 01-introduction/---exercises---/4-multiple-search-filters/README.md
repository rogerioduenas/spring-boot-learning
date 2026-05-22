# 🏋️ Exercise 04 — Dashboard with Dynamic Parameters (`Map`)

## 📝 Description

You must create a reporting endpoint that accepts multiple search filters at once, but the system does not know in advance which filters the user will choose to send.

---

## ⚙️ Technical Objectives

- Reinforce capturing all Query Parameters dynamically using `@RequestParam Map<String, String>`.

---

## 🎯 Routes and HTTP Methods

### `GET /reports`

---

## 📋 Business Rules

- Capture all request parameters using a `Map`.
- For this exercise, there is no need to filter real data.
- Simply retrieve the `Map`, print it to the console using `System.out.println`, and return the same `Map` in the response body with status `200 OK`.
- The goal is to see Spring inject the map correctly.

---

## 🧪 Postman Test Cases

### Request

```http
GET http://localhost:8080/reports?year=2024&brand=ford&condition=good
```

---

## ✅ Expected Result

A JSON response containing exactly the same keys and values sent in the URL, with the HTTP status:

```http
200 OK
```

### Example Response

```json
{
  "year": "2024",
  "brand": "ford",
  "condition": "good"
}
```