# 🏋️ Exercise 30 — Final Project: Library Book Checkout Workflow

## 📝 Description

Implement a complete book checkout system.

A borrower checks out a copy of a book. This operation must:

- update the number of available copies of the book;
- record the transaction;
- return a complete DTO containing the checkout receipt.

The entire workflow must be safe, transactional, and DTO-based. Any error must trigger a complete transaction rollback.

---

## ⚙️ Technical Objectives

Build a service orchestration involving multiple repositories.

Combine:

- transactional control;
- entity updates;
- exception handling;
- custom mappings;

to produce a cohesive, production-ready implementation.

---

## 📂 Required Structure

### Entities

- **Book**
    - `id`
    - `title`
    - `availableCopies`

- **Borrower**
    - `id`
    - `name`

- **BorrowingRecord**
    - `id`
    - `book`
    - `borrower`
    - `borrowDate`

### DTOs

- **BorrowRequestDTO**
    - `bookId`
    - `borrowerId`

- **ReceiptDTO**
    - `receiptId`
    - `bookTitle`
    - `borrowerName`
    - `checkoutDate`

---

## 🎯 Endpoint

### `POST /library/checkout`

**Response**

- Return **201 Created**.

---

## 📋 Business Rules

### Validation

- Verify that the book has available copies (`availableCopies > 0`).
- Otherwise, throw an exception.
- Also verify that the `Borrower` exists.

### Atomic Operations

- Decrement the `availableCopies` field of the `Book` entity by **1**.

### Transaction Recording

- Create and save a `BorrowingRecord` representing the checkout.

### Transactional Integrity

- If any step fails, or if an unexpected exception occurs during the save operation, the entire transaction must be rolled back.
- This means the book must **not** remain with its available copy count reduced.

### Response

- Convert the newly created record into a `ReceiptDTO`.
- Return it to the client.

---

# 🧪 Test Case (Postman)

## Request

```http
POST http://localhost:8080/library/checkout
```

```json
{
  "bookId": 1,
  "borrowerId": 10
}
```

## Expected Result (Success)

- **Status:** `201 Created` containing the receipt data.

### Verification

- Confirm that the `availableCopies` value of the book has been reduced by **1** in the database.
- If an attempt is made to check out a book with **0 available copies**, the API must return **400 Bad Request**, and **no changes** should be persisted to the database.