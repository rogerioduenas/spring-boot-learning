# 🏋️ Exercise 03 — The One-to-One Profile

## 📝 Description

Every employee has one and only one `EmployeeProfile` containing sensitive HR information (such as address and phone number). Your task is to implement a strict one-to-one relationship where the profile cannot exist without its corresponding employee.

---

## ⚙️ Technical Objectives

- Map a `@OneToOne` relationship
- Configure `@JoinColumn` with `unique = true` and `nullable = false` on the owning side
- Handle cascade deletion (when an employee is deleted, the associated profile must also be removed automatically)

---

## 📂 Required Structure

### Entities

**Employee**
- `id`
- `name`

**EmployeeProfile**
- `id`
- `address`
- `phoneNumber`
- `employee`

> Owning side of the one-to-one relationship:
>
> `@OneToOne` with `@JoinColumn(name = "employee_id", unique = true, nullable = false)`

---

## 🎯 Repositories and Services

### ProfileService

```java
public EmployeeProfile createProfile(Long employeeId, String address, String phone)
```

### EmployeeService

```java
public void deleteEmployee(Long employeeId)
```

---

## 📋 Business Rules

- To create a profile, the corresponding employee must already exist. Otherwise, throw an exception.
- When an employee is deleted, the database or JPA cascade must automatically remove the associated `EmployeeProfile` record, preventing orphan profiles.

---

## 🧪 Test Case

**When:**

Delete an `Employee` with ID `1` that has an associated `EmployeeProfile`.

**Then:**

The SQL logs should display:

```sql
DELETE FROM employee_profile ...
DELETE FROM employee ...
```

Or the reverse order, depending on the database constraints.

No orphan `EmployeeProfile` records should remain in the database.
