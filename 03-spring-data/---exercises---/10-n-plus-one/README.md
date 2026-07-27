# 🏋️ Exercise 10 — Defeating the N+1 Query Monster

## 📝 Description

You are building a dashboard for an API. A `Company` has multiple `Employee` entities mapped as `LAZY`. If you retrieve all companies and iterate through them to print their employees, Spring will execute one query to fetch the companies and then **N additional queries** to fetch the employees of each company individually. Your task is to fix this by using a custom query with `JOIN FETCH`.

---

## ⚙️ Technical Objectives

- Identify the **N+1 Query Problem** in the Hibernate logs.
- Fix the N+1 issue using `@Query` with a JPQL `JOIN FETCH`.

---

## 📂 Required Structure

### Entities

**Company**
- `id`
- `name`
- `employees`

```java
@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
```

**Employee**
- `id`
- `name`
- `company`

---

## 🎯 Repositories and Services

### CompanyRepository

Declare a custom query:

```java
@Query("SELECT c FROM Company c JOIN FETCH c.employees")
public List<Company> findAllWithEmployees();
```

---

## 📋 Business Rules

- Create a Service method that retrieves all companies along with their employees.
- Use the custom `findAllWithEmployees()` method to load all records and their associated collections in a single SQL execution.

---

## 🧪 Test Case

**Given:** There are 3 companies in the database, each with 2 employees.

**When:** Calling the default method:

```java
companyRepository.findAll();
```

and accessing the employees.

**Then:** The console log should display **4 SQL `SELECT` statements** (1 to retrieve the companies + 3 to retrieve the employees).

**When:** Calling:

```java
companyRepository.findAllWithEmployees();
```

**Then:** The console log should display **exactly 1 SQL `SELECT` statement** containing an `INNER JOIN` (or `LEFT JOIN`) that retrieves data from both tables in a single query.