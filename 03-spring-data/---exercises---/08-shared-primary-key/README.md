# 🏋️ Exercise 08 — Shared Primary Key in a 1:1 Relationship

## 📝 Description

In strongly coupled 1:1 relationships, it is possible to save database space and reduce index overhead by making the child entity's Primary Key exactly the same as the parent entity's Primary Key using the `@MapsId` annotation.

---

## ⚙️ Technical Objectives

- Map a `@OneToOne` relationship using `@MapsId`
- Understand how the child entity inherits its identifier from the parent entity

---

## 📂 Required Structure

### Entities

- `User` (`id`, `name`) → Standard auto-generated ID
- `UserProfile` (`id`, `bio`, `user`) → `@OneToOne` with `@MapsId` and `@JoinColumn(name = "user_id")`. (Its `id` field is **not** auto-generated; it is populated with the `User` ID.)

---

## 🎯 Repositories and Services

### UserService

```java
public UserProfile createUserProfile(Long userId, String bio)
```

---

## 📋 Business Rules

- Find the `User` by its ID.
- Create a `UserProfile` instance, set the bio, and associate the `User` with it.
- Save the `UserProfile` using its own repository.
- The corresponding profile row in the database must have an ID identical to the `User` ID.

---

## 🧪 Test Case

**When:** Save a profile for the `User` with ID `45`.

**Then:** The SQL logs should show:

```sql
INSERT INTO user_profile (user_id, bio) VALUES (45, '...')
```

When verifying the database, it should be confirmed that `user_profile.user_id` is both the **Primary Key** and the **Foreign Key**.