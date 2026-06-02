# 🏋️ Exercise 15 — Instance Control (Singleton vs Prototype)

## 📝 Description

Create a token or session ID generator. The goal is to demonstrate, in practice, the behavior of a component that must generate new data every time it is injected.

---

## ⚙️ Technical Objectives

- Learn and clearly distinguish Spring Bean scopes using `@Scope("prototype")`.

---

## 📂 Required Structure

### Component

**TokenGenerator**

- Annotated with `@Component`
- Configured with Prototype scope using `@Scope("prototype")`
- Add the following attribute:

```java
private final UUID id = UUID.randomUUID();
```

### Classes

- `TokenController`

---

## 🎯 HTTP Routes and Methods

### GET `/tokens/check`

---

## 📋 Business Rules

Inside your `TokenController`, inject **two instances** of `TokenGenerator` through the constructor, for example:

```java
public TokenController(TokenGenerator gen1, TokenGenerator gen2)
```

In the `GET` endpoint:

1. Compare the internal UUIDs of both generators.
2. Since the Bean scope is **Prototype**, the UUIDs must be different.
3. Return a JSON response containing:
    - The first UUID
    - The second UUID
    - The comparison result

---

## 🧪 Postman Test Cases

### Request

```http
GET http://localhost:8080/tokens/check
```

### Expected Result

A JSON response displaying two completely different UUIDs, proving that Spring created two separate object instances.

Example:

```json
{
  "generator1Id": "7b3c5d2f-3d6c-4f8d-9f4c-5c9a6f0b1d7a",
  "generator2Id": "a8d2f4b9-1e5f-4a7c-8d6b-2c3f9e7a1b4d",
  "areEqual": false
}
```