# 🏋️ Exercise 20 — Custom `@Query` with Pagination

## 📝 Description

You need to search for active users by department name, but the results must be returned in a paginated format. You must implement a custom `@Query` that supports pagination.

## ⚙️ Technical Objectives

- Pass a `Pageable` parameter to a custom `@Query`.
- Observe how Spring Data dynamically rewrites your custom query to add `LIMIT`/`OFFSET` and automatically executes a count query.

## 📂 Mandatory Structure

### Entities

- `Department` (`id`, `name`)
- `User` (`id`, `name`, `active`, `department`)

## 🎯 Repositories and Services

### UserRepository

```java
@Query("SELECT u FROM User u WHERE u.department.name = :deptName AND u.active = true")
public Page<User> findActiveUsersByDepartment(String deptName, Pageable pageable)
```

## 📋 Business Rules

- Pass the `Pageable` parameter directly to the custom `@Query` method.
- Return a `Page<User>` wrapper.

## 🧪 Test Case

**When:** Call `userRepository.findActiveUsersByDepartment("IT", PageRequest.of(0, 5))`.

**Then:** Verify that the Hibernate log contains both the paginated query and the count query required to calculate the pagination metadata.