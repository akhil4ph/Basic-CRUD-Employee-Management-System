# Basic-CRUD-Employee-Management-System

# Employee Management System (Basic CRUD)

A backend RESTful API built with **Java** and **Spring Boot** to perform basic CRUD (Create, Read, Update, Delete) operations for managing employee records.

---

## Features

- **Create** a new employee record
- **Retrieve** a list of all employees or a specific employee by ID
- **Update** existing employee details
- **Delete** an employee record
- Clean layered architecture (**Controller → Service → Repository → Entity**)

---

## Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Build Tool:** Maven
- **Architecture:** REST API, Layered Architecture (MVC / N-Tier)
- **IDE:** IntelliJ IDEA

---

## Project Structure

```text
Employee-Management-System/
├── src/
│   ├── main/
│   │   ├── java/in/employee/Employee_Management_System/
│   │   │   ├── controller/
│   │   │   │   └── EmployeeController.java
│   │   │   ├── entity/
│   │   │   │   └── Employee.java
│   │   │   ├── Repository/
│   │   │   │   └── EmployeeRepository.java
│   │   │   ├── service/
│   │   │   │   └── EmployeeService.java
│   │   │   └── EmployeeManagementSystemApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
