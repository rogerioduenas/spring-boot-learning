# 🏋️ Exercise 03 — User Registration with Creation Status

## 📝 Description

Simulate receiving data to register a new user in the system through the request body, returning the correct HTTP status for resource creation.

---

## ⚙️ Technical Objectives

- Reinforce the usage of `@PostMapping` and `@RequestBody`.
- Practice returning the correct status for newly created resources (`201 Created`).

---

## 📂 Required Structure

### Class: `User`

Fields:

- `id`
- `name`
- `role`

---

## 🎯 Routes and HTTP Methods

### `POST /users`

---

## 📋 Business Rules

- Receive the `User` object in the request body.
- Assign a simulated ID to the user (e.g., using `Math.random()`).
- Add the user to an in-memory list.
- Return the created object with the HTTP status `201 CREATED`.

---

## 🧪 Postman Test Cases

### Request

```http
POST http://localhost:8080/users
```

### JSON Body

```json
{
  "name": "dev_java",
  "role": "ADMIN"
}
```

---

## ✅ Expected Result

The same JSON object should be returned, now including the generated `id` field, with the HTTP status configured as:

```http
201 Created
```