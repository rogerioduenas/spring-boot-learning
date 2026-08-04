# 🏋️ Exercise 25 — A Failure-Proof Transaction (Handling Checked Exceptions in the Controller)

## 📝 Description

Create an API that processes money transfers between wallets.

Since this is a critical operation, if an external dependency throws a checked exception during the process, the entire transaction must be rolled back.

You must catch this exception at the Controller level to return a clean error message, ensuring that the database rollback has already been completed.

---

## ⚙️ Technical Objectives

- Maintain transactional integrity across multiple operations.
- Throw a checked exception from the Service layer to force a rollback.
- Properly handle the exception using:

```java
@RestControllerAdvice
```

avoiding exposing:

- stack traces

to the client.

---

## 📂 Required Structure

### Entities

#### Wallet

- `id`
- `holderName`
- `balance`

### Exception

#### TransferFailedException

**Type:**

Checked Exception

**Extends:**

```java
Exception
```

---

## 🎯 HTTP Routes and Methods

### Create Transfer

```http
POST /transfers
```

**Request Body**

```json
{
  "fromWalletId": 1,
  "toWalletId": 2,
  "amount": 100.0
}
```

---

## 📋 Business Rules

The Service must withdraw money from:

- Wallet A

and add it to:

- Wallet B

After that, the Service must call a fake method (mock method) that simulates an external failure.

Example:

```java
throw new TransferFailedException("Network Timeout");
```

The method must be annotated with:

```java
@Transactional(rollbackFor = Exception.class)
```

Create a:

```java
@RestControllerAdvice
```

to catch:

```java
TransferFailedException
```

and return:

```http
400 Bad Request
```

with a clean JSON response.

---

## 🧪 Postman Test Case

**Request**

```http
POST http://localhost:8080/transfers
```

**Expected Result**

```http
400 Bad Request
```

**Response Body**

```json
{
  "error": "Transaction failed: Network Timeout. All balances have been restored."
}
```

**Verification**

After the failure, retrieve the wallets again and confirm that:

- No money has been transferred.
- The original balances have been restored due to the transaction rollback.