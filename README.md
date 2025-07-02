<!-- Project Banner -->
<p align="center">
  <img src="eduTrack-banner.png" alt="EduTrack Banner" width="100%">
</p>

<h1 align="center">🎓 EduTrack</h1>
<p align="center"><b>A Java-Based Academic Management System</b></p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue?logo=java" />
  <img src="https://img.shields.io/badge/Database-JDBC-green" />
  <img src="https://img.shields.io/badge/MySQL-8.x-orange" />
  <img src="https://img.shields.io/badge/Platform-Console-lightgrey" />
 
</p>


## 📌 Overview

**EduTrack** is a modular and scalable student & course management system built using **Core Java** and **JDBC**.
It simulates a real-world academic backend, handling:

- 👨‍🎓 Students
- 📘 Courses
- 👩‍🏫 Instructors
- 📝 Enrollments
- 📊 Scores
- 💬 Feedback

Designed using the **DAO-Service layered architecture**, this system focuses on clean code, separation of concerns, and real-world business logic.
<br><br>

## 💡 Features

**EduTrack** is a console-based academic information management system that:

-  ✅ Manages **Students**, **Courses**, **Instructors**
-  ✅ Handles **Course Enrollment**
-  ✅ Allows **Score Assignment** and **Feedback Tracking**
-  ✅ Uses a layered architecture with **DAO-Service patterns**
-  ✅ Connects to a **MySQL database** using **JDBC**

<br><br>

## 🧱 Tech Stack

![Java](https://img.shields.io/badge/Java-17-blue)
![JDBC](https://img.shields.io/badge/Database-JDBC-green)
![MySQL](https://img.shields.io/badge/MySQL-8.x-orange)



| Layer           | Technology Used        |
|----------------|------------------------|
| Language        | Java (Core)            |
| Database        | MySQL                  |
| DB Connectivity | JDBC                   |
| Architecture    | DAO-Service Pattern    |
| IDE             | IntelliJ IDEA          |


<br><br>
## 📂 Folder Structure

EduTrack/src/jdbc
│
├── model/ # Bean classes (Student, Course, Instructor, etc.)
├── Dao/ # DAO interfaces
├── DaoImpl/ # JDBC implementation classes
├── service/ # Service interfaces (business logic)
├── serviceImpl/ # Service layer implementation
├── db/ # DB connection utility
├── main/MainOperation.java # Menu-driven console application
└── README.md

<br><br>

## 🧠 Layered Architecture

Main (UI/Menu)
│
▼
Service Layer (Business Logic)
│
▼
DAO Layer (Database Access)
│
▼
MySQL Database

<br><br>

## 🛠️ How to Run This Project

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/EduTrack.git
   
2. Open in IntelliJ IDEA
   
3. Create the MySQL database and tables using the provided SQL schema

4. Update DB credentials in DBConnection.java

5. Compile and run:

- javac MainOperation.java
- java  MainOperation.java
- 🎉 Start interacting with EduTrack!

<br><br>

# Future Improvements

1. 🎨 Adding GUI using JavaFX or Swing

2. 🔐 Adding authentication module (Login/Register)

<br><br>

## 🙋‍♀️ About Me
#### 👩‍💻 Rakhi Dixit

BCA Graduate | Java Developer | Problem Solver

“I built EduTrack as more than a project — it's my hands-on journey into building clean, real-world, backend systems using industry principles.”
 <H6>Connect With Me on - </H6>
📫 [LinkedIn](https://www.linkedin.com/in/rakhidixit08) 
    [GitHub](https://www.github.com/Rakhi-Dixit03)

