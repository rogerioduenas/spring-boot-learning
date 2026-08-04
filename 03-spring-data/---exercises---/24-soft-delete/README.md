# 🏋️ Exercise 24 — Safe Soft Delete Execution via REST

## 📝 Description

Expose a `DELETE` endpoint for a resource (for example, `Customer`) that performs a logical deletion (soft delete) instead of a physical deletion.

The goal is to prevent data loss while maintaining compliance with REST API standards.

---

## ⚙️ Technical Objectives

Connect the standard HTTP `DELETE` method directly to the soft delete rules in the repository.

Using:

- `@SQLDelete`
- `@SQLRestriction`

or by using manual status flags.

---

## 📂 Required Structure

### Entities

Use the `Customer` entity with the soft delete configuration created in **Exercise 09**.

---

## 🎯 HTTP Routes and Methods

### Delete

```http
DELETE /customers/{id}
```

**Response:**

```http
204 No Content
```

### Retrieve

```http
GET /customers
```

**Response:**

```http
200 OK
```

(should return only non-deleted records)

---

## 📋 Business Rules

When the `DELETE` endpoint is called, the following must be executed:

```java
repository.deleteById();
```

Verify that subsequent calls to:

```http
GET /customers
```

no longer return the deleted record.

However, the record must still physically exist in the database with:

```text
active = false
```

---

## 🧪 Postman Test Case

**Request**

```http
DELETE http://localhost:8080/customers/1
```

**Expected Result**

```http
204 No Content
```

Afterward:

```http
GET http://localhost:8080/customers
```

The customer with ID `1` should no longer appear.