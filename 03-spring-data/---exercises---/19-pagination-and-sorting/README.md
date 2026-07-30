# 🏋️ Exercise 19 — Repository-Level Pagination and Sorting

## 📝 Description

An API must return a product catalog sorted alphabetically. Loading all products at once is not scalable. You must implement pagination and sorting using the built-in support provided by Spring Data.

## ⚙️ Technical Objectives

- Learn how to use `Pageable`, `PageRequest`, and `Sort` in Spring Data repository queries.
- Understand how `Page<T>` returns metadata (total elements, total pages) along with the data.

## 📂 Mandatory Structure

### Entities

- `Product` (`id`, `name`, `price`)

## 🎯 Repositories and Services

### ProductRepository

- Extends `JpaRepository<Product, Long>`

### ProductService

```java
public Page<Product> getProductsPaged(int page, int size, String sortBy)
```

## 📋 Business Rules

- Build a `Pageable` object using:

```java
PageRequest.of(page, size, Sort.by(sortBy).ascending())
```

- Retrieve the product page from the repository and return it.

## 🧪 Test Case

**Given:** 10 products exist in the database.

**When:** Calling `getProductsPaged(0, 3, "name")`.

**Then:** The console SQL logs should show two queries: one with `LIMIT 3 OFFSET 0` (or the equivalent SQL syntax for pagination) and a separate `SELECT COUNT(*)` query to calculate the total number of pages.