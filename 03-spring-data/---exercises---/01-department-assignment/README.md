# 🏋️ Exercise 01 — Project Assignment

## 📝 Description

In a corporate system, an employee must be assigned to a department. Your task is to implement the logic for saving an employee while linking them to an existing department already stored in the database.

## ⚙️ Technical Objectives

- Practice using `@ManyToOne` with `@JoinColumn`
- Understand how to reference an existing parent entity without retrieving or modifying its entire state from the database
- Use a standard `JpaRepository` to save the child entity

## 📂 Required Structure

### Entities

**Department**
- `id`
- `name`

**Employee**
- `id`
- `name`
- `department`

Annotated with:

```java
@ManyToOne
@JoinColumn(name = "department_id", nullable = false)
```

### Exception

**DepartmentNotFoundException**
- Returns a custom error message

## 🎯 Repositories and Services

### EmployeeRepository

- Extends `JpaRepository<Employee, Long>`

### EmployeeService

```java
public Employee save(String name, Long departmentId)
```

## 📋 Business Rules

- Search for the department using `departmentId` through `DepartmentRepository`. If it does not exist, throw `DepartmentNotFoundException`.
- Instantiate a new `Employee` object, associate it with the retrieved department, and save it using `EmployeeRepository`.
- If the `departmentId` parameter is `null`, the database must reject the save operation (guaranteed by `nullable = false` in `@JoinColumn`).

## 🧪 Test Case

**Given:** A department with ID `1` (`"Engineering"`) already exists in the database.

**When:** `employeeService.save("Alice", 1L)` is executed.

**Then:** An SQL `INSERT` statement should be displayed in the console showing `department_id = 1` being saved, and the persisted `Employee` object should be returned.

**When:** `employeeService.save("Bob", 999L)` (non-existent department) is executed.

**Then:** A `DepartmentNotFoundException` must be thrown, and no `INSERT` statement should be executed.