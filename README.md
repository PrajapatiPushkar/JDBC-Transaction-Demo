 📌 JDBC Transaction Demo

A simple Java project demonstrating **JDBC Transaction Management** using MySQL.
This project explains how to handle multiple database operations safely using `commit()` and `rollback()`.

🚀 Project Description

This project shows how to:

* Connect Java application to MySQL database using JDBC
* Disable auto-commit mode
* Execute multiple SQL queries in a single transaction
* Commit transaction if all queries execute successfully
* Rollback transaction if any query fails
* Handle SQL exceptions properly

This concept is widely used in real-world applications like:

* Banking systems
* Payment processing systems
* Order management systems

---

🛠️ Technologies Used

* Java (JDK 8 or above)
* JDBC
* MySQL
* Maven
* IntelliJ IDEA

---
 📂 Project Structure

```
JDBC-Transaction-Demo
│
├── src/main/java
│   └── JDBCDemo.java
│
├── pom.xml
└── .gitignore
```

---

 ⚙️ Database Setup

 1️⃣ Create Database

```sql
CREATE DATABASE spring_fist;
```
 2️⃣ Create Table

```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    marks INT
);
```

 3️⃣ Update Database Credentials in Java File

```java
private static final String URL = "jdbc:mysql://localhost:3306/spring_fist";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

---

 🔄 How Transaction Works

1. Disable auto-commit:

```java
con.setAutoCommit(false);
```

2. Execute multiple SQL operations.

3. If all operations succeed:

```java
con.commit();
```

4. If any operation fails:

```java
con.rollback();
```

This ensures **Atomicity (ACID property)** — either all database operations succeed or none are applied.

---

 ▶️ How to Run

1. Clone the repository:

```
git clone https://github.com/PrajapatiPushkar/JDBC-Transaction-Demo.git
```

2. Open the project in IntelliJ IDEA.

3. Make sure MySQL server is running.

4. Update database username and password.

5. Run `JDBCDemo.java`.

---

 📚 Key Concepts Covered

* JDBC Connection
* PreparedStatement
* Transaction Management
* Commit & Rollback
* Exception Handling
* ACID Properties

---

 🎯 Purpose

This project is created for learning and understanding JDBC transaction handling in Java backend development.

---

 👨‍💻 Author

Pushkar Prajapati
B.Tech CSE Student
Aspiring Java Backend Developer 🚀

---
