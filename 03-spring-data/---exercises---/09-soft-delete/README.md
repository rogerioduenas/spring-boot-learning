# 🏋️ Exercise 09 — The Soft Delete Pattern

## 📝 Description

In enterprise databases, physically deleting customer records is highly discouraged. You need to implement a **Soft Delete** mechanism, where calling the delete method only deactivates the customer, and all standard query methods automatically filter out inactive customers.

## ⚙️ Technical Objectives

- Learn how to implement **Soft Delete** without changing the repository's standard delete method calls.
- Use Hibernate annotations `@SQLDelete` and `@Where` (or `@Filter`) at the entity level.

## 📂 Required Structure

### Entities

**Customer**

- `id`
- `name`
- `active`

Annotated with:

```java
@SQLDelete(sql = "UPDATE customer SET active = false WHERE id = ?")
@Where(clause = "active = true")
```

> **Note:** In Spring Boot 3 / Hibernate 6, `@Where(clause = "...")` has been replaced with `@SQLRestriction("active = true")`.

## 🎯 Repositories and Services

### CustomerService

```java
public void removeCustomer(Long id)

public List<Customer> getAllActiveCustomers()
```

## 📋 Business Rules

- When `removeCustomer` is called, use the repository's standard `deleteById` method.
- Internally, Hibernate should intercept the delete operation and execute an SQL `UPDATE` statement instead of a `DELETE`.
- When `getAllActiveCustomers` queries the repository, Hibernate should automatically append `AND active = true` to the generated SQL behind the scenes.

## 🧪 Test Case

### When

Call:

```java
customerRepository.deleteById(1L);
```

### Then

The SQL console should display:

```sql
UPDATE customer SET active = false WHERE id = 1
```

---

### When

Call:

```java
customerRepository.findAll();
```

### Then

The SQL displayed in the console should include:

```sql
WHERE active = true
```

And the customer marked with **Soft Delete** must not appear in the returned list.