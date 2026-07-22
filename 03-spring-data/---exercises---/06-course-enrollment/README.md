# 🏋️ Exercise 06 — Many-to-Many Course Enrollment

## 📝 Description

Implement a simple course enrollment system. A **Student** can enroll in multiple **Courses**, and a **Course** can have multiple **Students**. You need to map this relationship using a join table.

## ⚙️ Technical Objectives

- Map a `@ManyToMany` association.
- Configure the join table using `@JoinTable` on the owning side.
- Understand how to manage insertions into the join table through the owning entity.

## 📂 Required Structure

### Entities

**Student** (`id`, `name`, `courses`)  
→ Owning side, `@ManyToMany` with `@JoinTable` specifying the join columns.

**Course** (`id`, `title`, `students`)  
→ Inverse side, `@ManyToMany(mappedBy = "courses")`

## 🎯 Repositories and Services

### StudentService

```java
public void enrollStudentInCourse(Long studentId, Long courseId)
```

## 📋 Business Rules

- Retrieve the **Student** and **Course** by their respective IDs.
- Add the **Course** to the **Student**'s collection of courses.
- Save the **Student** entity. The join table should be populated automatically.

## 🧪 Test Case

**When:** Student `2` enrolls in Course `10`.

**Then:** The SQL console should execute:

```sql
INSERT INTO student_course (student_id, course_id) VALUES (2, 10);
```