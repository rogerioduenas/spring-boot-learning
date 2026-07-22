# 🏋️ Exercise 07 — Preventing Disasters with Cascade Delete

## 📝 Description

A common production disaster occurs when deleting an entity accidentally propagates the deletion to other important reference tables (for example, deleting a `Product` and unintentionally deleting its `Category`, which also removes unrelated products). Your task is to configure safe cascade operations.

## ⚙️ Technical Objectives

- Selectively apply `CascadeType.PERSIST` and `CascadeType.MERGE`
- Specifically avoid `CascadeType.REMOVE` and `CascadeType.ALL` to protect reference data

## 📂 Required Structure

### Entities

- `Category` (`id`, `name`)
- `Product` (`id`, `name`, `category`) → `@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})` with `@JoinColumn(name = "category_id")`

## 🎯 Repositories and Services

### ProductService

```java
public void deleteProduct(Long productId)
```

## 📋 Business Rules

- When a `Product` is deleted, it must be removed from the database.
- Its associated `Category` must **not** be deleted. The category must remain completely intact in the database.

## 🧪 Test Case

**Given:** Category `1` (`"Electronics"`) contains Product `10` (`"Smartphone"`) and Product `11` (`"Laptop"`).

**When:** You delete Product `10`.

**Then:** The SQL logs should show only:

```sql
DELETE FROM product WHERE id = 10
```

Executing `categoryRepository.findById(1L)` should still return the `"Electronics"` category, with the `"Laptop"` product remaining intact.