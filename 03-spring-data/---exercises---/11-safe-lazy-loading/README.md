# 🏋️ Exercise 11 — Safe Lazy Loading (The DTO Bridge)

## 📝 Description

In modern Spring Boot development, returning JPA entities directly from a Controller often causes a `LazyInitializationException` when Jackson attempts to serialize lazily loaded associations outside the scope of an active transaction. Your task is to implement a method in the Service layer that retrieves a primary entity, safely maps its data to a DTO, and initializes only the required associations before the transaction is closed.

---

## ⚙️ Technical Objectives

- Understand what a `LazyInitializationException` is and why it occurs.
- Practice mapping JPA entities to DTOs within the boundaries of an active transaction.
- Use `Hibernate.initialize()` or explicitly access the getters to safely trigger lazy loading.

---

## 📂 Required Structure

### Entities

#### `Author`

- `id`
- `name`
- `books` → `@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)`

#### `Book`

- `id`
- `title`
- `author`

### DTO

#### `AuthorDTO`

- `id`
- `name`
- `bookTitles` → A simple list (`List<String>`) containing the titles of the books.

---

## 🎯 Repositories and Services

### `AuthorService`

```java
@Transactional(readOnly = true)
public AuthorDTO getAuthorDTO(Long authorId)
```

---

## 📋 Business Rules

- Retrieve the `Author` by its ID inside the method annotated with `@Transactional`.
- Initialize the lazy-loaded `books` collection within the transaction (for example, by calling `.size()`, iterating through the collection, or mapping it to the DTO).
- Convert the entity data into an `AuthorDTO` and return it.
- The Controller must never receive the JPA entity directly, preventing serialization issues.

---

## 🧪 Test Case

**Given:** An author with three registered books exists.

**When:** `getAuthorDTO(1L)` is called.

**Then:** A single `AuthorDTO` containing the titles of all three books must be returned. No `LazyInitializationException` should occur because the lazy-loaded collection was initialized while the transaction was still active.