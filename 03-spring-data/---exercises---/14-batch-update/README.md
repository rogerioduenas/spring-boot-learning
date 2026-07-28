# 🏋️ Exercise 14 — JPQL vs Native Query for Bulk Updates

## 📝 Description

At midnight, the platform must automatically apply a **10% discount** to all products belonging to a specific category. Fetching thousands of products into memory, modifying them, and saving each one individually would be extremely inefficient. Your task is to implement a **bulk update** using a single query.

---

## ⚙️ Technical Objectives

- Learn how to perform bulk updates using **JPQL** with `@Modifying`.
- Understand the importance of using `clearAutomatically = true` to keep the persistence context synchronized.

---

## 📂 Required Structure

### Entities

#### `Category`

- `id`
- `name`

#### `Product`

- `id`
- `name`
- `price`
- `category`

---

## 🎯 Repositories and Services

### `ProductRepository`

```java
@Modifying(clearAutomatically = true)
@Query("UPDATE Product p SET p.price = p.price * 0.9 WHERE p.category.id = :categoryId")
public int applyDiscountToCategory(Long categoryId)
```

---

## 📋 Business Rules

- Annotate the query with `@Modifying` to indicate that it performs a write (DML) operation.
- Use `clearAutomatically = true` to prevent Hibernate's persistence context from returning stale prices after the database is updated directly.

---

## 🧪 Test Case

**When:** `applyDiscountToCategory(1L)` is executed.

**Then:**

- The SQL log should display only a single statement similar to:

```sql
UPDATE product
SET price = ...
WHERE category_id = ?
```

- If a product from the category is retrieved immediately afterward, within the same transaction, it should reflect the updated price with the applied discount.