# 🏋️ Exercise 26 — N+1 Problem Resolution API (The Optimized Detail View)

## 📝 Description

Create an endpoint to retrieve a single **Company** along with the complete list of its **Employees**. If implemented naively, this endpoint will trigger a large number of database queries due to lazy loading. Your task is to optimize this endpoint so that all related data is fetched using **exactly one database query**.

---

## ⚙️ Technical Objectives

- Use **JOIN FETCH** queries directly in a REST endpoint to control database performance.

---

## 📂 Required Structure

### Entities and DTOs

#### Entities

- Company
- Employee

#### DTOs

- CompanyDetailDTO (`id`, `name`, `employees`)

> `employees` must be a list of `EmployeeDTO`.

---

## 🎯 Endpoints and HTTP Methods

### GET `/companies/{id}/details`

**Response**

- Return **200 OK**.

---

## 📋 Business Rules

- Write a repository query using **JOIN FETCH** to load both the company and all of its employees simultaneously based on the provided ID.
- Ensure the service uses this optimized query instead of `findById()`.
- Convert the result into a `CompanyDetailDTO` and return it.

---

## 🧪 Test Case (Postman)

### Request

```http
GET http://localhost:8080/companies/1/details
```

### Expected Result

- Status **200 OK**.

### Verification

Check the application logs. There must be **only one SELECT statement**, using a **JOIN** to load all required data.