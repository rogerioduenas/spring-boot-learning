# 🏋️ Exercise 17 — Overriding Rollback Behavior for Checked Exceptions

## 📝 Description

In your billing system, if an error occurs while preparing an invoice, the system must abort the operation and undo all changes that were made. However, some integration errors with external APIs are classified as Checked Exceptions (`IOException` / `Exception`), which by default do not trigger a rollback in Spring. You must override this default behavior.

## ⚙️ Technical Objectives

- Understand Spring transaction rollback behavior regarding Checked vs Unchecked exceptions.
- Explicitly configure rollback behavior using `@Transactional(rollbackFor = Exception.class)`.

## 📂 Mandatory Structure

### Entities

- `Invoice` (`id`, `amount`)

### Exception

- `InvoiceProcessingException` → Extends `Exception` (Checked Exception)

## 🎯 Repositories and Services

### InvoiceService

```java
@Transactional(rollbackFor = Exception.class)
public void processInvoice(Long id, double amount) throws InvoiceProcessingException
```

## 📋 Business Rules

In the `processInvoice` method:

- Update the invoice status and save it.
- Simulate a failure by throwing an `InvoiceProcessingException`.
- Since `rollbackFor = Exception.class` is configured, the transaction must be rolled back, and the status change must not be persisted in the database.

## 🧪 Test Case

**When:** `processInvoice()` is executed and throws `InvoiceProcessingException`.

**Then:** Verify the database; the invoice status and amount must remain completely unchanged (rolled back).