# 🏋️ Exercise 16 — Applying Unique Constraints

## 📝 Description

A company must not register two employees with exactly the same tax identification number (CPF/SSN) in the database. You must configure a **composite unique constraint** at the database level to guarantee this integrity rule.

---

## ⚙️ Technical Objectives

- Define **table-level unique constraints** using the `@Table` annotation and the `uniqueConstraints` attribute.

---

## 📂 Required Structure

### Entities

- `Employee (id, firstName, lastName, taxId)` → `@Table(uniqueConstraints = @UniqueConstraint(name = "uk_employee_tax_id", columnNames = {"taxId"}))`

---

## 🎯 Repositories and Services

### EmployeeService

```java
@Transactional
public Employee registerEmployee(String firstName, String lastName, String taxId)
```

---

## 📋 Business Rules

- Configure the database table mapping so that a **unique index** is automatically created for the `taxId` column.
- If your service attempts to register a duplicate tax ID, the **database constraint** must take effect and throw a `DataIntegrityViolationException` (or a similar database constraint violation exception).

---

## 🧪 Test Case

**Given:** An employee with the tax ID `"123-456"` already exists in the database.

**When:** Attempting to save a second employee with the tax ID `"123-456"`.

**Then:** The save operation must fail by throwing a **database constraint violation exception**, preventing duplicate records from being inserted into the database.