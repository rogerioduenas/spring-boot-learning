# 🏋️ Exercise 10 — Resource Deletion Without Response Body (No Content)

## 📝 Description

Simulate the deletion of a `Task` from the system based on the provided ID. Professional REST APIs should not return text or JSON when deleting a resource — only a success status with no content.

---

## ⚙️ Technical Objectives

- Practice using `@DeleteMapping`.
- Master the use of HTTP status `204 NO CONTENT` with `ResponseEntity.noContent().build()`.

---

## 📂 Required Structure

### Class: `Task`

```java
Task {
    Long id;
    String description;
}
```

> **Note:** Populate your static list with a few sample tasks.

---

## 🎯 Routes and HTTP Verbs

### DELETE `/tasks/{id}`

---

## 📋 Business Rules

- If the `id` exists in the list:
    - Remove the corresponding object from the static list.
    - Return only the `204 NO CONTENT` status with an empty response body.

- If the `id` does not exist:
    - Return `404 NOT FOUND`.

---

## 🧪 Postman Test Cases

### ✅ Success Case

```http
DELETE http://localhost:8080/tasks/1
```

**Expected Result:**
- Completely empty response body
- Status: `204 No Content`

---

### ❌ Failure Case

```http
DELETE http://localhost:8080/tasks/55
```

**Expected Result:**
- Status: `404 Not Found`