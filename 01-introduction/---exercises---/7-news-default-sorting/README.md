# 🏋️ Exercise 07 — Default Value Configuration

## 📝 Description

A news listing endpoint needs to display data in a specific order. However, if the user does not specify the sorting direction, the system must safely assume a default value.

---

## ⚙️ Technical Objectives

- Practice using `@RequestParam(defaultValue = "...")`.

---

## 🎯 Routes and HTTP Methods

```http
GET /news
```

---

## 📋 Business Rules

- The route must receive a parameter called `orderBy`.
- If the user does not provide this parameter, Spring should automatically fill it with the value `"date"`.
- Return a simulated string:

```text
Results ordered by: [parameter value]
```

- Always return status `200 OK`.

---

## 🧪 Postman Test Cases

### Without Parameter

```http
GET http://localhost:8080/news
```

✅ Expected response:

```text
Results ordered by: date
```

---

### With Parameter

```http
GET http://localhost:8080/news?orderBy=views
```

✅ Expected response:

```text
Results ordered by: views
```