# 🏋️ Exercise 13 — Projection-Based Queries (Saving Memory)

## 📝 Description

Your database contains a very large `UserProfile` table, including lengthy biographies and avatars stored as binary data. When displaying only a list of users, loading the entire entity is extremely inefficient. You must create a query that returns only the username and email using a lightweight Projection.

---

# ⚙️ Technical Objectives

- Understand and practice **Interface Projections** in Spring Data JPA.
- Optimize memory usage and I/O by loading only the columns that are actually required.

---

# 📂 Required Structure

## Entity

### `UserProfile`

- `id`
- `username`
- `email`
- `heavyBio`
- `heavyAvatar`

### `UserProfileSummary`

```java
getUsername()

getEmail()
```

---

# 🎯 Repositories and Services

## `UserProfileRepository`

```java
@Query("SELECT u.username as username, u.email as email FROM UserProfile u")
public List<UserProfileSummary> findAllSummaries()
```

---

# 📋 Business Rules

- Implement the `UserProfileSummary` interface.
- Write a custom JPQL query using `@Query`, selecting only the required fields.
- Use aliases that match the method names defined in the Projection interface.

---

# 🧪 Test Case

**When:** `findAllSummaries()` is called.

**Then:** The generated SQL should explicitly contain something similar to:

```sql
SELECT username, email
FROM user_profile
```

and **must not** include the `heavy_bio` or `heavy_avatar` columns.