# 🏋️ Exercise 18 — Read-Only Optimization for Reporting Engines

## 📝 Description

Your backend needs to generate a massive sales report. Loading thousands of transaction records only for reading purposes causes unnecessary overhead because Hibernate allocates memory for "dirty checking" (change detection). You must optimize this process.

## ⚙️ Technical Objectives

- Apply `@Transactional(readOnly = true)` to optimize memory usage and query execution plans.
- Understand how the read-only mode disables entity dirty checking within the Hibernate session context.

## 📂 Mandatory Structure

### Entities

- `SaleTransaction` (`id`, `amount`, `timestamp`)

## 🎯 Repositories and Services

### SalesReportService

```java
@Transactional(readOnly = true)
public List<SaleTransaction> getDailyReport()
```

## 📋 Business Rules

- Mark the service method with `readOnly = true`.
- Fetch the transactions.
- Note: Inside a read-only transaction, if you accidentally attempt to modify an entity's properties, Hibernate will ignore change detection and will not flush those changes to the database at commit time.

## 🧪 Test Case

**When:** `getDailyReport()` is executed.

**Then:** Verify performance metrics or logs; no SQL `UPDATE` statement should be triggered, even if an entity setter was temporarily accessed inside the service, demonstrating that dirty checking was successfully disabled.