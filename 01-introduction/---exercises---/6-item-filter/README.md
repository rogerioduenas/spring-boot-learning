# 🏋️ Exercise 06 — Filtering by Multiple IDs (Lists)

## 📝 Description

A product comparison screen needs to receive multiple IDs at once through the URL in order to search for and return a list of the selected items.

---

## ⚙️ Technical Objectives

- Practice using `@RequestParam` mapped to a List (`List<Long>` or `List<Integer>`).

---

## 📂 Required Structure

### Class

```java
Item (id, name)
```

> **Note:** Preload the IDs `10`, `20`, `30`, and `40` in memory.

---

## 🎯 Routes and HTTP Methods

```http
GET /compare
```

---

## 📋 Business Rules

- Capture the `ids` parameter as a list of numbers.
- Iterate through your in-memory list and return only the items whose IDs were provided in the parameter.
- Always return status `200 OK`.

---

## 🧪 Postman Test Cases

### Request

```http
GET http://localhost:8080/compare?ids=10,30,40
```

or using repeated query parameters:

```http
GET http://localhost:8080/compare?ids=10&ids=30
```

---

## ✅ Expected Result

A JSON array containing only the objects corresponding to IDs `10`, `30`, and `40`.