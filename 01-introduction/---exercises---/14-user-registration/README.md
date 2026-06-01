# 🏋️ Exercise 14 — Basic Registration Security (Exception Handler)

## 📝 Description

Prevent underage users from registering in the system by throwing a business exception and handling it globally through Spring.

---

## ⚙️ Technical Objectives

- Practice handling business validation exceptions using `@RestControllerAdvice`.

---

## 📂 Required Structure

### DTO

`AccountRequest`

Fields:

- `name`
- `age`

### Exception

`InvalidAgeException`

---

## 🎯 Endpoint

### POST `/accounts`

---

## 📋 Functional Requirements

- The Controller must send the request data to `AccountService`.
- The Service must validate the `age` field.
- If the age is less than **18**, the Service must throw an `InvalidAgeException`.
- A global exception handler (`@RestControllerAdvice`) must catch the exception and return:
    - HTTP Status: **422 Unprocessable Entity**
    - A custom JSON response containing the error message.

---

## 🧪 Postman Test Cases

### ✅ Successful Registration

#### Request Example

```json
{
  "name": "John",
  "age": 20
}
```

#### Expected Result

- Status: **201 Created**

---

### ❌ Underage Registration

#### Request Example

```json
{
  "name": "John",
  "age": 15
}
```

#### Expected Result

- Status: **422 Unprocessable Entity**

Example response:

```json
{
  "error": "Registration is not allowed for users under 18 years old"
}
```