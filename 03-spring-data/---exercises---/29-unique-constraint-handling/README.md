# 🏋️ Exercise 29 — Error Handling for a Composite Unique Constraint

## 📝 Description

Build a REST endpoint for account registration. The combination of `email` and `taxId` must be unique across the system.

If the database rejects a duplicate registration, the exception must be converted into a clean, developer-friendly validation response instead of returning the raw database exception stack trace.

---

## ⚙️ Technical Objectives

- Capture database engine exceptions within a Global Exception Handler.
- Expose structured error messages to API clients.

---

## 📂 Required Structure

### Entities

- **Account**
    - `id`
    - `email`
    - `taxId`

Create a **composite unique constraint** for `email` + `taxId`.

---

## 🎯 Endpoint

### `POST /accounts`

**Responses**

- `201 Created` on success.
- `409 Conflict` when a duplicate account is detected.

---

## 📋 Business Rules

When an account registration attempts to insert an existing `email` and `taxId` combination:

- Capture the `DataIntegrityViolationException` in a `@RestControllerAdvice`.
- Convert it to a **409 Conflict** response.
- Return a clear JSON response indicating that an account with the provided information already exists.

---

# 🧪 Test Case (Postman)

## Request

```http
POST http://localhost:8080/accounts
```

Send a duplicate account registration.

## Expected Result

- **Status:** `409 Conflict`

**Response**

```json
{
  "message": "Account registration conflict. The email or tax ID already exists."
}
```