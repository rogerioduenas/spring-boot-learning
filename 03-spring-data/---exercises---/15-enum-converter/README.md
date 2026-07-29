# 🏋️ Exercise 15 — Safe Enum Converter

## 📝 Description

In the system, each account has a status: `ACTIVE`, `INACTIVE`, or `SUSPENDED`.

Storing these values using `ORDINAL` is extremely dangerous because any change in the enum order can corrupt existing data. Storing them as text is safer, but it consumes more storage space.

Your task is to implement a JPA converter to store compact codes in the database.

## ⚙️ Technical Objectives

Use `@Convert` together with `AttributeConverter` to map an Enum to custom database codes (for example: `"A"`, `"I"`, and `"S"`).

## 📂 Required Structure

### Enum

**AccountStatus**

- `ACTIVE` → `"A"`
- `INACTIVE` → `"I"`
- `SUSPENDED` → `"S"`

### Entity

**Account**

- `id`
- `ownerName`
- `status` → annotated with:

```java
@Convert(converter = AccountStatusConverter.class)
```

## 🎯 Classes

### AccountStatusConverter

```java
implements AttributeConverter<AccountStatus, String>
```

## 📋 Business Rules

Implement the converter so that, when saving the entity, the Enum is stored as a single-character code.

When reading data from the database, the code must be correctly converted back to the corresponding `AccountStatus` Enum value.

## 🧪 Test Case

### When:

An `Account` with status `ACTIVE` is saved.

### Then:

The generated SQL should insert the value `'A'` into the `status` column.

---

### When:

The account is read again from the database.

### Then:

The `status` attribute of the returned entity should be the Enum value `AccountStatus.ACTIVE`.