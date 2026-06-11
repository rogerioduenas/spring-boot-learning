# 🏋️ Exercise 28 — Dynamic Reading of Configuration Arrays

## 📝 Description

Your application contains a list of administrator email addresses authorized to receive system reports. You must load this list from the `application.yaml` file as a structured Java list.

## ⚙️ Technical Objectives

- Reinforce the injection of structured property lists/arrays using `@Value` and simple SpEL expressions.

## 📂 Required Structure

In `application.yaml`:

```yaml
app:
  admin-emails: "admin@admin.com,director@director.com,devops@devops.com"
```

Class:

- `SystemController` (where you will inject the list as `List<String>`).

## 🎯 Routes and HTTP Methods

### GET `/system/admins`

## 📋 Functional Requirements

- Use `@Value("#{'${app.admin-emails}'.split(',')}")` to inject the property directly into a `List<String>` field named `admins`.
- The endpoint must return only this list with status **200 OK**.

## 🧪 Postman Test Cases

```http
GET http://localhost:8080/system/admins
```

**Expected Result:** Returns a JSON array containing exactly the email address strings configured in the YAML file.