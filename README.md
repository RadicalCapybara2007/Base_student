# Demo Student API

This project is a Spring Boot application for managing and exposing student information through a REST API. It uses Java 21, Spring Web MVC, Spring Data JPA, and PostgreSQL.

## Overview

The application currently provides a read-only endpoint to retrieve all students from the database. The project is structured as a simple backend service and is intended as a demo or learning project.

## Features

- Spring Boot 4 backend
- PostgreSQL integration with JPA
- Student entity model and DTO mapping
- REST endpoint to fetch all students
- Maven project setup for Java 21

## Tech Stack

- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/base_student/demo/
│   │       ├── DemoApplication.java
│   │       ├── controller/
│   │       │   └── StudentController.java
│   │       ├── dto/
│   │       │   └── StudentDto.java
│   │       ├── model/
│   │       │   └── StudentModel.java
│   │       ├── repository/
│   │       │   └── StudentRepository.java
│   │       └── service/
│   │           └── StudentService.java
│   └── resources/
│       ├── application.properties
│       └── application-dev.properties
└── test/
    └── java/
        └── com/base_student/demo/
            └── DemoApplicationTests.java
```

## Prerequisites

Before running the project, make sure you have:

- Java 21 installed
- Maven installed
- PostgreSQL running locally
- A database named `student` available

## Database Configuration

The project includes a dev configuration file at `src/main/resources/application-dev.properties`.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student
spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.driver-class-name=org.postgresql.Driver
```

By default, the app is configured with the main application properties file:

```properties
spring.application.name=demo
```

If you want to use the dev database settings during local development, activate the `dev` profile when starting the project.

## Running the Project

1. Start PostgreSQL and ensure the `student` database exists.
2. Open a terminal in the project root.
3. Run:

```bash
./mvnw spring-boot:run
```

If you want to explicitly use the dev configuration:

```bash
SPRING_PROFILES_ACTIVE=dev ./mvnw spring-boot:run
```

Alternatively, you can run the app from your IDE using the main class:

```text
com.base_student.demo.DemoApplication
```

## API Endpoints

### Get all students

```http
GET /student
```

Response example:

```json
[
  {
    "id": 1,
    "name": "John",
    "lastName": "Doe",
    "phone": "1234567890",
    "email": "john.doe@example.com"
  }
]
```

> This project currently exposes a read-only list endpoint for students. More CRUD endpoints can be added as the application evolves.

## Notes

- `StudentModel` maps to the `student` table.
- `StudentDto` is used for API responses.
- `StudentRepository` extends `JpaRepository` to provide database access methods.
- `StudentService` converts entity objects into DTOs before returning them from the controller.

## License

This project does not currently include a license file. If you are using it for personal or educational purposes, you can treat it as a demo project unless you add a specific license.
