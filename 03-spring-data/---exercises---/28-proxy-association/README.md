# 🏋️ Exercise 28 — Create a Child Entity Using Only the Parent ID

## 📝 Description

In many APIs, child entities are created by sending only their own data along with the ID of the parent entity (for example, creating a `Review` associated with a `Book`). Implement an optimized endpoint that associates the child entity with its parent without wasting a database query to load the full parent entity.

---

## ⚙️ Technical Objectives

Learn how to use:

- `entityManager.getReference()`

or

- `repository.getReferenceById()` from Spring Data (formerly `getOne()`)

to avoid unnecessary `SELECT` queries when mapping foreign keys.

---

## 📂 Required Structure

### Entities

- **Book**
    - `id`
    - `title`

- **Review**
    - `id`
    - `content`
    - `book`

---

## 🎯 Endpoint

### `POST /reviews`

**Request Body**

```json
{
  "content": "Amazing read!",
  "bookId": 1
}
```

---

## 📋 Business Rules

In the service layer, **do not use**:

```java
bookRepository.findById(bookId)
```

Instead, use:

```java
bookRepository.getReferenceById(bookId)
```

This method creates a lightweight proxy of the `Book` entity containing only its ID.

The implementation must:

1. Associate this proxy with the `Review` entity.
2. Save the `Review`.

This allows the foreign key to be populated directly without executing a `SELECT` query on the `Book` table.

---

# 🧪 Test Case (Postman)

## Request

```http
POST http://localhost:8080/reviews
```

## Expected Result

- **Status:** `201 Created`

### Verification

Check the database logs. There should be **no `SELECT` query** executed against the `book` table—only a direct `INSERT` into the `review` table with `book_id = 1`.