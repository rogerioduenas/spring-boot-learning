# 🏋️ Exercise 12 — Derived Query Filtering by a Nested Association

## 📝 Description

The sales team needs to filter products by category name. Instead of writing manual SQL or JPQL, you must use **Spring Data JPA Query Derivation** exclusively, allowing Spring Data JPA to automatically navigate the relationship between the entities.

---

## ⚙️ Technical Objectives

- Practice the naming conventions of Spring Data JPA derived queries.
- Learn how to navigate object properties using `_` or the property path (for example, `findByCategoryName`).

---

## 📂 Required Structure

### Entities

#### Category

- `id`
- `name`

#### Product

- `id`
- `name`
- `category` → `@ManyToOne` with `@JoinColumn(name = "category_id")`

---

## 🎯 Repositories and Services

### ProductRepository

```java
public List<Product> findByCategory_NameIgnoreCase(String name);
```

---

## 📋 Business Rules

- Implement the query method using only Spring Data JPA naming conventions.
- The query must retrieve all products whose category has the specified name, ignoring case differences.
- The relationship (`Category -> name`) must be traversed correctly.

---

## 🧪 Test Case

**When:** `productRepository.findByCategory_NameIgnoreCase("electronics")` is executed.

**Then:** The SQL console should display a `JOIN` (or an equivalent subquery), filtering the categories table with a condition similar to:

```sql
WHERE LOWER(category.name) = ?
```