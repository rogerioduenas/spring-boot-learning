# 🏋️ Exercise 12 — Isolation with Input and Output DTOs

## 📝 Description

Create an employee registration endpoint where the entity contains sensitive data (such as salary), but the response DTO must not expose this information to the client.

---

# ⚙️ Technical Goals

- Reinforce the separation between Entity and DTO.
- Practice manual data conversion (`Entity -> DTO`).

---

# 📂 Required Structure

## Entity
- `Employee`
    - `id`
    - `name`
    - `role`
    - `salary`

## Output DTO
- `EmployeeDTO`
    - `id`
    - `name`
    - `role`

> The `salary` field must NOT be present in the DTO.

## Classes
- `EmployeeController`
- `EmployeeService`

---

# 🎯 Routes and HTTP Verbs

## POST `/employees`

Receives the complete JSON payload in the request body.

### Example

```http
POST http://localhost:8080/employees
```

---

# 📋 Business Rules

- The Controller receives the entity (or an input DTO) and passes it to `EmployeeService`.

- The Service:
    - Saves the entity into an in-memory list.
    - Converts the entity into `EmployeeDTO`.
    - Returns the DTO to the Controller.

- The Controller must respond with:
    - Status `201 Created`
    - Only the Output DTO data.

---

# 🧪 Postman Test Cases

## ✅ Request

```http
POST http://localhost:8080/employees
```

### Request Body

```json
{
  "name": "Mike",
  "role": "Dev",
  "salary": 5000.0
}
```

---

## 🎯 Expected Result

- Status: `201 Created`

### Response Body

```json
{
  "id": 1,
  "name": "Mike",
  "role": "Dev"
}
```

> The response JSON must NOT contain the `salary` field.