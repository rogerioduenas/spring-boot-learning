# 🏋️ Exercise 16 — Safe Updates with ResponseEntityExceptionHandler

## 📝 Description

When attempting to retrieve or modify a resource using an ID with an invalid format (for example, a string instead of a number), Spring throws internal exceptions. In this exercise, you will extend Spring's base exception handling class to properly capture and handle request failures.

---

## ⚙️ Technical Objectives

- Practice extending `ResponseEntityExceptionHandler` in your global exception handler (`@RestControllerAdvice`).

---

## 🎯 HTTP Routes and Methods

### GET `/items/{id}`

> The expected ID type must be a numeric value (e.g., `Long`).

---

## 📋 Business Rules

If the client calls the endpoint using a string instead of a numeric ID, such as:

```http
GET /items/abc
```

Spring will, by default, throw a `MethodArgumentTypeMismatchException`.

In your `@RestControllerAdvice`:

1. Ensure that it extends `ResponseEntityExceptionHandler`.
2. Handle `MethodArgumentTypeMismatchException`.
3. Return a clean JSON response with HTTP status **400 Bad Request**.
4. Provide a user-friendly error message instead of the default Spring error response.

---

## 🧪 Postman Test Cases

### Invalid Request

```http
GET http://localhost:8080/items/textInsteadOfNumber
```

### Expected Result

**HTTP Status:** `400 Bad Request`

**Response Body:**

```json
{
  "message": "The 'id' parameter must be a valid number"
}
```

The response should clearly indicate that the provided value for the `id` parameter is invalid and that a numeric value is required.