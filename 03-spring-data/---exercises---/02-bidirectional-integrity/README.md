# 🏋️ Exercise 02 — Bidirectional Integrity (The Two-Way Association)

## 📝 Description

A department has many employees. To make the relationship bidirectional, we must be able to navigate from a `Department` to its list of `Employees`. The challenge is to implement a safe helper method that synchronizes both sides of the relationship in memory before saving, ensuring that the foreign key is correctly populated in the database.

## ⚙️ Technical Objectives

- Implement a bidirectional `@OneToMany` association using the `mappedBy` attribute.
- Avoid the common pitfall of forgetting to set the back-reference (foreign key) on the child side.
- Use helper methods (`addEmployee`) to maintain bidirectional consistency following OOP principles.

## 📂 Required Structure

### Entities

**Department** (`id`, `name`, `employees`)
```java
@OneToMany(mappedBy = "department")
```

**Employee** (`id`, `name`, `department`)
```java
@ManyToOne
@JoinColumn(name = "department_id")
```

## 🎯 Repositories and Services

### DepartmentService

```java
public Department addEmployeeToDepartment(Long departmentId, String employeeName)
```

## 📋 Business Rules

1. Find the `Department` by its ID.
2. Create a new `Employee` with the provided name.
3. Use a custom helper method `department.addEmployee(employee)` to add the employee to the department's list and set the department reference inside the `Employee` object.
4. Save the `Department` using the `DepartmentRepository`.

> **Note:** If you use `CascadeType.ALL` or `CascadeType.PERSIST` on the `@OneToMany` association, the employee should be saved automatically when the department is saved. If cascading is not configured, both entities must be saved manually. For this exercise, use **Parent-to-Child cascading**.

## 🧪 Test Case

**When:** Add an employee named `"Charlie"` to `Department` with ID `1`.

**Then:** The SQL logs in the console should show a `SELECT` on the `Department`, followed by an `INSERT` into the `Employee` table with the correct `department_id`.