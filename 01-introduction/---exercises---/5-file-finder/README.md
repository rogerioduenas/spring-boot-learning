# 🏋️ Exercise 05 — The Optional File Finder

## 📝 Description

A file system allows users to search for documents through a directory tree in the URL. The file name is required, but the file extension is optional.

---

## ⚙️ Technical Objectives

- Practice using `@PathVariable` with the `required = false` attribute.
- Dynamically handle strings based on the presence of optional paths in the URL.

---

## 🎯 Routes and HTTP Methods

```http
GET /files/{name}
```

```http
GET /files/{name}/{extension}
```

---

## 📋 Business Rules

- If the user provides only the file name  
  Example:

```http
/files/document
```

Return the following text:

```text
Searching for the file document with the default .txt extension
```

---

- If the user also provides the extension  
  Example:

```http
/files/photo/png
```

Return:

```text
Searching for the file photo with the .png extension
```

---

- Always return status `200 OK`.

---

## 🧪 Postman Test Cases

### Only Required Parameter

```http
GET http://localhost:8080/files/report
```

✔ Verify the returned message.

---

### With Optional Parameter

```http
GET http://localhost:8080/files/spreadsheet/xlsx
```

✔ Verify that the system correctly captured the extension.