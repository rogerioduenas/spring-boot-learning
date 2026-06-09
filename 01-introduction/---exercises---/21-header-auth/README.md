# 🏋️ Exercise 21 — Security Validation with `@RequestHeader`

## 📝 Description

Simulate the security of a restricted endpoint. The system must read a custom token sent in the HTTP request header. If the token is missing or invalid, access must be immediately denied.

## ⚙️ Technical Objectives

- Reinforce the use of `@RequestHeader` to read request metadata.
- Integrate with `@RestControllerAdvice` to handle business authentication failures.

## 📂 Required Structure

Exception:

- `UnauthorizedException`

Classes:

- `AdminController`
- `AdminService`

## 🎯 Routes and HTTP Methods

### GET `/admin/auth`

## 📋 Functional Requirements

- The Controller must capture a header named `Admin-Token`.
- The Service must validate the header value.
- The correct token must be stored in `application.yaml` (example: `app.security.token=secret123`) and injected using `@Value`.
- If the header is not provided or its value is different from `secret123`, throw an `UnauthorizedException`.
- Your Advice must catch the exception and return **401 UNAUTHORIZED** with a clean response body.
- If the token is valid, return **200 OK** with a success message.

## 🧪 Postman Test Cases

### Missing or Invalid Header

```http
GET http://localhost:8080/admin/secret-data
```

**Expected Result:** `401 Unauthorized`

### Valid Header

Add the following header in the **Headers** tab of Postman:

| Key | Value |
|------|--------|
| X-Admin-Token | secret123 |

**Expected Result:** `200 OK`